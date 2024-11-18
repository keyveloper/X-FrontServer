import com.example.frontServer.service.BoardService

dpackage com.example.frontServer.service

import com.example.frontServer.dto.board.BoardResponse
import com.example.frontServer.dto.timeline.TimelineResult
import com.example.frontServer.dto.timeline.TimelineSearchPolicy
import com.example.frontServer.entity.Timeline
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
    private val boardRepository: BoardRepository,
    private val boardService: BoardService
) {
    @Transactional
    fun findByReceiverId(receiverId: Long): List<TimelineResult> {
        // find all board id in timeline rep
        val timelineCursor = timelinesCursorRepository.findByReceiverId(receiverId)

        val lastSeenId = timelineCursor?.lastSeenId ?: 0L // 수정 필요

        // find all timeline
        val timelines: List<Timeline> = timelineRepository.findAllByPolicy(
            TimelineSearchPolicy(
                receiverId = receiverId,
                lastSeenId = lastSeenId,
                currentTime = LocalDateTime.now(),
                pageSize = 10
            )
        )
        val boardIds: List<Long> = timelines.map {it.boardId}

        // 이거 transaction 질문
        val boards: List<BoardResponse> = boardService.findByIds(boardIds)

        return boards.map {}


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