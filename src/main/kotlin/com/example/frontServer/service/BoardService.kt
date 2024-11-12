package com.example.frontServer.service

import com.example.frontServer.dto.*
import com.example.frontServer.dto.board.BoardResponse
import com.example.frontServer.dto.board.BoardResult
import com.example.frontServer.dto.board.SaveBoardRequest
import com.example.frontServer.entity.Board
import com.example.frontServer.entity.QBoard.board
import com.example.frontServer.repository.BoardRepository
import com.example.frontServer.repository.FollowRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.*

@Service
class BoardService(
    val boardRepository: BoardRepository,
    val notificationService: NotificationService,
    val fileService: FileService,
    val followRepository: FollowRepository,
    val timelineService: TimelineService,
    val likeService: LikeService

) {

    @Transactional
    fun findAll(): List<BoardResult> {
        return boardRepository.findAllBoardWithComment()
            .map {
                BoardResult.of(it, )
            }
    }


    private fun findUsernameByWriterId(writerId: Long): String {

    }

    private fun countLikesByBoardId(boardId: Long): Int {

    }

    @Transactional
    fun findRepliesByParentId(parentId: Long): List<BoardAdditionalInfo> {
        val boardInfos = boardRepository.findRepliesByParentId(parentId)

        return boardInfos.map {
            BoardAdditionalInfo.of(
                boardInfo = it,
                likeCount = countLikes(it.board.id!!),
                replyCount = boardRepository.countRepliesById(it.board.id!!)
            )
        }
    }

    private fun addReadingCount(board: Board) {
        board.readingCount++
        boardRepository.save(board)
    }

    @Transactional
    fun save(request: SaveBoardRequest, userId: Long, username: String) : Boolean {
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
        return true
    }

    private fun saveTimeline(boardId: Long, followers: List<Long>) {
        timelineService.save(boardId, followers)
    }

    private fun sendNotification(boardNotificationInfo: NotificationInfoDto) {
        notificationService.save(boardNotificationInfo)
    }

    private fun countLikes(boardId: Long): Long {
        val users = likeService.findAllByBoardId(boardId)
        if (users.isEmpty()) {
            return -1
        }
        return users.size.toLong()
    }

    fun deleteById(id: Long): Boolean {
        return boardRepository.deleteBoardById(id) > 0
    }
}