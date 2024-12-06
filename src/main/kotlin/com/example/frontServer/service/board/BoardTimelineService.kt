package com.example.frontServer.service.board

import com.example.frontServer.dto.timeline.TimelineBoardResult
import com.example.frontServer.dto.timeline.TimelineRequest
import com.example.frontServer.repository.BoardRepository
import com.example.frontServer.service.TimelineService
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class BoardTimelineService( // board-timeline rep or api connection
    private val timelineService: TimelineService,
    private val boardRepository: BoardRepository,
) {
    @Transactional
    fun findTimelineNext(timelineRequest: TimelineRequest): List<TimelineBoardResult> {
        val ids = findTimelineNextBoardIds(timelineRequest)
            return boardRepository.findAllWithCommentCountByIds(ids)
            .map { TimelineBoardResult.of(it) }
    }

    @Transactional
    fun findTimelineBefore(timelineRequest: TimelineRequest): List<TimelineBoardResult> {
        val ids = findTimelineBeforeBoardIds(timelineRequest)
        return boardRepository.findAllWithCommentCountByIds(ids)
            .map { TimelineBoardResult.of(it) }
    }

    private fun findTimelineNextBoardIds(timelineRequest: TimelineRequest): List<Long> {
        return timelineService.findAllNextBoardIds(timelineRequest)
    }

    private fun findTimelineBeforeBoardIds(timelineRequest: TimelineRequest): List<Long> {
        return timelineService.findAllBeforeBoardIds(timelineRequest)
    }

    fun saveTimeline(boardId: Long, followers: List<Long>) {
        timelineService.save(boardId, followers)
    }
}