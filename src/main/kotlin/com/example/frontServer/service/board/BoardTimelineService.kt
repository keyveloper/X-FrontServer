package com.example.frontServer.service.board

import com.example.frontServer.dto.timeline.TimelineBoardResult
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
    fun findTimelineByIds(receiverId: Long): List<TimelineBoardResult> {
        val ids = findBoardIdsByReceiverId(receiverId)
        return boardRepository.findAllWithCommentCountByIds(ids)
            .map { TimelineBoardResult.of(it)}
    }

    private fun findBoardIdsByReceiverId(receiverId: Long): List<Long> {
        return timelineService.findAllBoardIdsByReceiverId(receiverId)
    }

    fun saveTimeline(boardId: Long, followers: List<Long>) {
        timelineService.save(boardId, followers)
    }
}