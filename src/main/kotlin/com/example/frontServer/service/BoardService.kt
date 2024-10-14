package com.example.frontServer.service

import com.example.frontServer.dto.*
import com.example.frontServer.entity.Board
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
) {
    @Transactional
    fun findAll() : List<GetAllBoardResult> {
        val boards : List<Board> = boardRepository.findAllWithUsername()
        return boards.map { GetAllBoardResult.of(it, countRepliesById(it.id!!)) }
    }

    @Transactional
    fun findById(id: Long): GetBoardResult? {
        val board : Board? = boardRepository.findById(id).orElse(null) // optional -> ?

        return board?.let {
            addReadingCount(it)
            GetBoardResult.of(it)
        }
    }

    private fun addReadingCount(board: Board) {
        board.readingCount++
        boardRepository.save(board)
    }

    @Transactional
    fun save(request: SaveBoardRequest, userId: Long, username: String) : Boolean {
        return if (request.files != null) {
            val token = UUID.randomUUID().toString()
            fileService.saveBoardFile(request.files, token)
            boardRepository.save(
                Board(
                    writer = userId,
                    fileApiUri = "/img/${token}",
                    textContent = request.textContent
                )
            )
            sendNotification(
                NotificationInfoDto(
                    message = "new post from $username",
                    receivers = followRepository.findFollowersByUsername(username).map {it.id!!}
                )
            )

            true
        } else {
            boardRepository.save(
                Board(
                    writer = userId,
                    textContent = request.textContent
                )
            )
            sendNotification(
                NotificationInfoDto(
                    message = "new post from $username",
                    receivers = followRepository.findFollowersByUsername(username).map {it.id!!}
                )
            )
            true
        }
    }

    private fun sendNotification(boardNotificationInfo: NotificationInfoDto) {
        notificationService.save(boardNotificationInfo)
    }

    fun deleteById(id: Long): Boolean {
        return boardRepository.deleteBoardById(id) > 0
    }

    private fun countRepliesById(id: Long) : Long {
        return boardRepository.countRepliesById(id)
    }
}