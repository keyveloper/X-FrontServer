package com.example.frontServer.service

import com.example.frontServer.dto.BoardWithUsernameDto
import com.example.frontServer.dto.GetAllBoardResponse
import com.example.frontServer.dto.GetAllBoardResult
import com.example.frontServer.dto.GetBoardResult
import com.example.frontServer.entity.Board
import com.example.frontServer.entity.Timeline
import com.example.frontServer.repository.BoardRepository
import com.example.frontServer.repository.TimelineRepository
import org.springframework.stereotype.Service

@Service
class TimelineService(
    private val timelineRepository: TimelineRepository,
    private val boardRepository: BoardRepository
) {
    fun findBoardsByReceiverId(receiverId: Long): List<GetAllBoardResult> {
        // find all board id in timeline rep
        val timelineBoardIds: List<Long> =
            timelineRepository.findAllByReceiverIdWithInOneDay(receiverId).map {it.boardId}

        // find all board in board rep
        val boardWithUsernames: List<BoardWithUsernameDto> = timelineBoardIds.mapNotNull {
            boardRepository.findByIdWithUsername(it)
        }

        val results: List<GetAllBoardResult> = boardWithUsernames.map {
            GetAllBoardResult.of(it, countRepliesById(it.board.id!!))
        }

        return results
    }

    private fun countRepliesById(id: Long) : Long {
        return boardRepository.countRepliesById(id)
    }

    fun save(boardId: Long, followersId: List<Long>): Boolean {
        followersId.map {
            timelineRepository.save(
                Timeline(
                    boardId = boardId,
                    receiverId = it
                )
            )
        }
        return true
    }
}