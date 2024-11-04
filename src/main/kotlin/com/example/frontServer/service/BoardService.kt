package com.example.frontServer.service

import com.example.frontServer.dto.*
import com.example.frontServer.entity.Board
import com.example.frontServer.entity.Timeline
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
    val timelineService: TimelineService

) {
    @Transactional
    fun findAll() : List<GetAllBoardResult> {
        val boards : List<BoardWithUsernameDto> = boardRepository.findAllWithUsername()
        return boards.map { GetAllBoardResult.of(it, countRepliesById(it.board.id!!)) }
    }

    @Transactional
    fun findById(id: Long): GetBoardResult? {
        val board : BoardWithUsernameDto? = boardRepository.findByIdWithUsername(id) // optional -> ?

        return board?.let {
            addReadingCount(it.board)
            GetBoardResult.of(it)
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
                    writer = userId,
                    fileApiUri = "/img/${token}",
                    textContent = request.
                    textContent
                )
            )
        } else {
            boardRepository.save(
                Board(
                    writer = userId,
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

    fun deleteById(id: Long): Boolean {
        return boardRepository.deleteBoardById(id) > 0
    }

    private fun countRepliesById(id: Long) : Long {
        return boardRepository.countRepliesById(id)
    }
}