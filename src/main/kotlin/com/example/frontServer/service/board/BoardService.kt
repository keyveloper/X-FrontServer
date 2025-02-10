package com.example.frontServer.service.board

import com.example.frontServer.dto.board.request.BoardSaveRequest
import com.example.frontServer.dto.board.request.BoardUpdateRequest
import com.example.frontServer.dto.board.request.CommentGetRequest
import com.example.frontServer.dto.board.request.SingleBoardRequest
import com.example.frontServer.dto.board.response.CommentResult
import com.example.frontServer.dto.board.response.SingleBoardResult
import com.example.frontServer.dto.logstash.BoardWriteEventLog
import com.example.frontServer.dto.notification.request.NotificationSaveRequest
import com.example.frontServer.dto.timeline.request.TimelineSaveRequest
import com.example.frontServer.entity.Board
import com.example.frontServer.enum.EntityType
import com.example.frontServer.enum.LogEvent
import com.example.frontServer.enum.NotificationType
import com.example.frontServer.exception.NotFoundEntityException
import com.example.frontServer.repository.board.BoardRepository
import com.example.frontServer.repository.follow.FollowRepository
import com.example.frontServer.repository.user.UserRepository
import com.example.frontServer.service.FileService
import com.example.frontServer.service.like.LikeApiService
import com.example.frontServer.service.noti.KafkaProducerService
import com.example.frontServer.service.timeline.TimelineApiService
import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.transaction.Transactional
import net.logstash.logback.argument.StructuredArguments
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*
import kotlin.math.log

@Service
class BoardService(
    private val boardRepository: BoardRepository,
    private val fileService: FileService,
    private val followRepository: FollowRepository,
    private val likeApiService: LikeApiService,
    private val timelineApiService: TimelineApiService,
    private val userRepository: UserRepository,
    private val kafkaProducerService: KafkaProducerService
) {
    private val logstashLogger = LoggerFactory.getLogger("com.example.logstash")
    private val logger = KotlinLogging.logger {}

    @Transactional
    // get Comment init
    fun findInitComment(request: CommentGetRequest): List<CommentResult> {
        return boardRepository.findInitComment(request.parentId)
            .map {
                val writerName = userRepository.findById(it.board.writerId)
                    .map { user -> user.username}
                    .orElse("")

                val likeCount = fetchLikeCount(it.board.id!!)
                CommentResult.of(
                    boardWithCommentCount = it,
                    writerName = writerName,
                    likeCount = likeCount
                )
            }
    }

    fun findNextComment(request: CommentGetRequest): List<CommentResult>  {
        return boardRepository.findNextComment(request.parentId, request.endCommentId)
            .map {
                val writerName = userRepository.findById(it.board.writerId)
                    .map { user -> user.username}
                    .orElse("")

                val likeCount = fetchLikeCount(it.board.id!!)
                CommentResult.of(
                    boardWithCommentCount = it,
                    writerName = writerName,
                    likeCount = likeCount
                )
            }
    }

    fun findSingleBoard(request: SingleBoardRequest): SingleBoardResult {
        val boardOptional = boardRepository.findById(request.boardId)
        return if (boardOptional.isPresent) {
            val writerName = userRepository.findById(boardOptional.get().writerId)
                .map { user -> user.username}
                .orElse("")

            val likeCount = fetchLikeCount(boardOptional.get().id!!)
            SingleBoardResult.of(
                board = boardOptional.get(),
                writerName = writerName,
                likeCount = likeCount
            )
        } else {
            throw NotFoundEntityException(
                entityType = EntityType.BOARD.code,
                id = request.boardId
            )
        }
    }


    // save
    @Transactional
    fun save(request: BoardSaveRequest, writerId: Long, writerName: String) {
        val savedBoard: Board = if (request.files != null) {
            val token = UUID.randomUUID().toString()
            fileService.saveBoardFile(request.files, token)
            boardRepository.save(
                Board(
                    writerId = writerId,
                    fileApiUrl = "/img/${token}",
                    textContent = request.textContent
                )
            )
        } else {
            boardRepository.save(
                Board(
                    writerId = writerId,
                    textContent = request.textContent
                )
            )
        }
        val boardId = savedBoard.id!!
        val receiverIds: List<Long> = followRepository.findFollowersById(writerId).map {it.followerId}

        saveNotification(
            requests = receiverIds.map {
                NotificationSaveRequest(
                    publisherId = writerId,
                    receiverId = it,
                    notificationType = NotificationType.BOARD,
                    targetBoardId = boardId
                )
            },
        )

        val event = BoardWriteEventLog(
            logEvent = LogEvent.BOARD_WRITE.code,
            boardId = boardId,
            userId = writerId
        )
        saveTimeline(boardId, receiverIds)
        logstashLogger.info(
            "Board event occurred",
            StructuredArguments.keyValue("boardWriteEvent", event)
        )
        logger.info {"send Event logger to logstash server: $event"}
    }

    // delete
    fun deleteById(id: Long): Board? {
        val targetBoardOptional = boardRepository.findById(id)

        return if (targetBoardOptional.isPresent) {
            boardRepository.delete(targetBoardOptional.get())
            targetBoardOptional.get()
        } else {
            null
        }
        // 여기서 Exception 보내도 되고 ?
        // 아니면 Int로 보내도 되고 ? 아니면 Board로 보내던가?
    }

    // update
    fun updateContentById(request: BoardUpdateRequest): Board? {
        val targetBoardOptional = boardRepository.findById(request.boardId)
        return if (targetBoardOptional.isPresent) {
            val targetBoard = targetBoardOptional.get()
            targetBoard.textContent = request.textContent
            boardRepository.save(targetBoard)
            targetBoard
        } else {
            null
        }
    }

    private fun saveTimeline(boardId: Long, receivers: List<Long>) {
        timelineApiService.saveRequest(
            receivers.map {
                TimelineSaveRequest(
                    boardId = boardId,
                    receiverId = it,
                )
            }
        )
    }

    private fun addReadingCount(board: Board) {
        board.readingCount++
        boardRepository.save(board)
    }


    private fun saveNotification(
        requests: List<NotificationSaveRequest>,
    ) {
        requests.map {
            kafkaProducerService.sendNoti(it)
        }
    }

    private fun fetchLikeCount(targetBoardId: Long): Long {
        return likeApiService.fetchLikeCounts(targetBoardId)
    }
}