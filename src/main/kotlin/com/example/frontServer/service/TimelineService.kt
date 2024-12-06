package com.example.frontServer.service


import com.example.frontServer.dto.timeline.TimelineRequest
import com.example.frontServer.entity.Timeline
import com.example.frontServer.repository.timeline.TimelineCursorRepository
import com.example.frontServer.repository.timeline.TimelineRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TimelineService(
    private val timelineRepository: TimelineRepository,
    private val timelinesCursorRepository: TimelineCursorRepository,
) {
    fun findAllNextBoardIds(timelineRequest: TimelineRequest): List<Long> {
        return timelineRepository.findAllNextBoardIds(timelineRequest)
            .map { it.boardId }
    }

    fun findAllBeforeBoardIds(timelineRequest: TimelineRequest): List<Long> {
        return timelineRepository.findAllBeforeBoardIds(timelineRequest)
            .map { it.boardId }
    }

    @Transactional
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