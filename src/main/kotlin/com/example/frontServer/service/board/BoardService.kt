package com.example.frontServer.service.board

import com.example.frontServer.dto.*
import com.example.frontServer.dto.board.BoardAllResult
import com.example.frontServer.dto.board.BoardCommentResult
import com.example.frontServer.dto.board.BoardResult
import com.example.frontServer.dto.board.BoardSaveRequest
import com.example.frontServer.dto.notification.NotificationSaveRequest
import com.example.frontServer.dto.timeline.TimelineBoardResult
import com.example.frontServer.dto.timeline.TimelineRequest
import com.example.frontServer.entity.Board
import com.example.frontServer.enum.NotificationType
import com.example.frontServer.repository.BoardRepository
import com.example.frontServer.repository.FollowRepository
import com.example.frontServer.service.FileService
import com.example.frontServer.service.LikeService
import com.example.frontServer.service.NotificationService
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.*

@Service
class BoardService(
    private val boardRepository: BoardRepository,
    private val notificationService: NotificationService,
    private val fileService: FileService,
    private val followRepository: FollowRepository,
    private val likeService: LikeService,
    private val boardTimelineService: BoardTimelineService
) {

    @Transactional
    fun findAll(): List<BoardAllResult> {
        return boardRepository.findAllWithCommentCount()
            .map {
                BoardAllResult.of(it, it.board.writerId.toString(), 0)
            }
    }

    @Transactional
    fun findById(id: Long): BoardResult? {
        val boardWithComment = boardRepository.findBoardWithCommentById(id)
        return boardWithComment?.let {
            val board = boardWithComment.board
            val commentCount = boardWithComment.getCommentCount()
            val boardCommentResult: List<BoardCommentResult> = boardWithComment.comments.map {
                BoardCommentResult.of(
                    it,
                    findUsernameByWriterId(it.id!!),
                    countLikesByBoardId(it.id!!)
                )
            }
            addReadingCount(it.board)
            BoardResult.of(
                board = board,
                commentCount = commentCount,
                writerName = "",
                likeCount = 0,
                boardCommentResult
            )
        }
    }

    fun findTimelineNext(timelineRequest: TimelineRequest): List<TimelineBoardResult> {
        return boardTimelineService.findTimelineNext(timelineRequest)
    }

    fun findTimelineBefore(timelineRequest: TimelineRequest): List<TimelineBoardResult> {
        return boardTimelineService.findTimelineBefore(timelineRequest)
    }


    private fun findUsernameByWriterId(writerId: Long): String {
        /*TODO*/
        return ""
    }

    private fun countLikesByBoardId(boardId: Long): Int {
        return 0
    }


    private fun addReadingCount(board: Board) {
        board.readingCount++
        boardRepository.save(board)
    }

    @Transactional
    fun save(request: BoardSaveRequest, writerId: Long, writerName: String, language: String) {
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
        val receivers: List<Long> = followRepository.findFollowersByUsername(writerName).map {it.id!!}

        saveNotification(
            requests =  receivers.map {
                NotificationSaveRequest(
                    publisherId = writerId,
                    receiverId = it,
                    notificationType = NotificationType.BOARD,
                    targetBoardId = boardId
                )
            },
            language = language
        )
        saveTimeline(boardId, receivers)
    }

    private fun saveTimeline(boardId: Long, receivers: List<Long>) {
        boardTimelineService.saveTimeline(boardId, receivers)
    }

    private fun saveNotification(
        requests: List<NotificationSaveRequest>,
        language: String
    ) {
        notificationService.save(requests, language)
    }

    private fun countLikes(boardId: Long): Long {
        val users = likeService.findAllByBoardId(boardId)
        if (users!!.isEmpty()) {
            return -1
        }
        return users.size.toLong()
    }

    fun deleteById(id: Long): Boolean {
        return boardRepository.deleteBoardById(id) > 0
    }
}