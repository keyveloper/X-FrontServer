package com.example.frontServer.service

import com.example.frontServer.dto.board.BoardWithComment
import com.example.frontServer.dto.timeline.TimelineResult
import com.example.frontServer.entity.Timeline
import com.example.frontServer.repository.BoardRepository
import com.example.frontServer.repository.TimelineRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class TimelineService(
    private val timelineRepository: TimelineRepository,
    private val boardRepository: BoardRepository
) {
    @Transactional
    fun findByReceiverId(receiverId: Long): List<TimelineResult> {
        // find all board id in timeline rep
        val timelineBoardIds: List<Long> =
            timelineRepository.findAllByReceiverIdWithInOneDay(receiverId).map {it.boardId}

        // find all board in board rep
        val boardWithComments: List<BoardWithComment> = boardRepository.findAllBoardWithCommentByIds(
            timelineBoardIds
        )

        //
        return boardWithComments.map {
            TimelineResult.of(it, "", 0)
        }
    }

    fun save(boardId: Long, followersId: List<Long>) {
        followersId.map {
            timelineRepository.save(
                Timeline(
                    boardId = boardId,
                    receiverId = it
                )
            )
        }
    }
}