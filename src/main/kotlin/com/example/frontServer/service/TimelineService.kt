package com.example.frontServer.service

import com.example.frontServer.dto.board.BoardWithComment
import com.example.frontServer.dto.timeline.TimelineBoardResult
import com.example.frontServer.dto.timeline.TimelineSearchPolicy
import com.example.frontServer.entity.Timeline
import com.example.frontServer.entity.TimelineCursor
import com.example.frontServer.repository.timeline.TimelineCursorRepository
import com.example.frontServer.repository.timeline.TimelineRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class TimelineService(
    private val timelineRepository: TimelineRepository,
    private val timelinesCursorRepository: TimelineCursorRepository,
) {
    fun findAllBoardIdsByReceiverId(receiverId: Long): List<Long> {
        return timelineRepository.findAllBoardIdByReceiverId(receiverId)
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