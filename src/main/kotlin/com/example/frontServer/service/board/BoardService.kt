package com.example.frontServer.service.board

import com.example.frontServer.dto.*
import com.example.frontServer.dto.board.BoardAllResult
import com.example.frontServer.dto.board.BoardCommentResult
import com.example.frontServer.dto.board.BoardResult
import com.example.frontServer.dto.board.BoardSaveRequest
import com.example.frontServer.dto.timeline.TimelineBoardResult
import com.example.frontServer.entity.Board
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

    fun findTimelineByReceiverId(receiverId: Long): List<TimelineBoardResult> {
        return boardTimelineService.findTimelineByIds(receiverId)
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
    fun save(request: BoardSaveRequest, userId: Long, username: String) {
        val savedBoard: Board = if (request.files != null) {
            val token = UUID.randomUUID().toString()
            fileService.saveBoardFile(request.files, token)
            boardRepository.save(
                Board(
                    writerId = userId,
                    fileApiUrl = "/img/${token}",
                    textContent = request.
                    textContent
                )
            )
        } else {
            boardRepository.save(
                Board(
                    writerId = userId,
                    textContent = request.textContent
                )
            )
        }
        val boardId= savedBoard.id!!
        val receivers = followRepository.findFollowersByUsername(username).map {it.id!!}

        sendNotification(
            NotificationInfoDto(
                message = "new post from $username \n${request.textContent}",
                receivers = receivers
            )
        )

        saveTimeline(boardId, receivers)
    }

    private fun saveTimeline(boardId: Long, receivers: List<Long>) {
        boardTimelineService.saveTimeline(boardId, receivers)
    }

    private fun sendNotification(boardNotificationInfo: NotificationInfoDto) {
        notificationService.save(boardNotificationInfo)
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