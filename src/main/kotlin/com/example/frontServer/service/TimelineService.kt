package com.example.frontServer.service

import com.example.frontServer.dto.board.BoardResult
import com.example.frontServer.dto.board.BoardWithComment
import com.example.frontServer.dto.timeline.TimelineBoardResult
import com.example.frontServer.dto.timeline.TimelineSearchPolicy
import com.example.frontServer.entity.Timeline
import com.example.frontServer.entity.TimelineCursor
import com.example.frontServer.repository.BoardRepository
import com.example.frontServer.repository.TimelineCursorRepository
import com.example.frontServer.repository.TimelineRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class TimelineService(
    private val timelineRepository: TimelineRepository,
    private val timelinesCursorRepository: TimelineCursorRepository,
    private val boardRepository: BoardRepository
) {
    @Transactional
    fun findByReceiverId(receiverId: Long): List<TimelineBoardResult> {
        if (!timelineRepository.existsByReceiverId(receiverId)) {
            timelinesCursorRepository.save(
                TimelineCursor(
                    id = null,
                    receiverId = receiverId,
                    lastSeenId = 0
                )
            )
        }

        // find all board id in timeline rep
        val timelineCursor = timelinesCursorRepository.findByReceiverId(receiverId)

        // for policy
        val lastSeenId = timelineCursor?.lastSeenId ?: 0L // 수정 필요

        // find all timeline
        val timelines: List<Timeline> = timelineRepository.findAllByPolicy(
            TimelineSearchPolicy(
                receiverId = receiverId,
                lastSeenId = lastSeenId,
                currentTime = LocalDateTime.now(),
                pageSize = 10L
            )
        )

        // update new lastSeenID
        timelines.lastOrNull()?.let { lastTimeline ->
            val newLastSeenId = lastTimeline.id!! // Timeline id = nullable
            timelinesCursorRepository.updateLastSeenId(receiverId, newLastSeenId)
        }

        val boardIds: List<Long> = timelines.map {it.boardId}

        // 이거 transaction 질문
        val boards: List<BoardWithComment> = boardRepository.
        findAllBoardWithCommentByIds(boardIds)
        return boards.map {
            TimelineBoardResult.of(it)
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