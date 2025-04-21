package com.example.frontServer.service.timeline

import com.example.frontServer.dto.timeline.request.TimelineGetRequest
import com.example.frontServer.dto.timeline.response.TimelineBoardGetResult
import com.example.frontServer.repository.board.BoardRepository
import com.example.frontServer.repository.user.UserRepository
import com.example.frontServer.service.LikeApiService
import org.springframework.stereotype.Service

@Service
class TimelineBoardService(
    private val boardRepository: BoardRepository,
    private val timelineService: TimelineApiService, // for http request
    private val likeApiService: LikeApiService,
    private val userRepository: UserRepository
) {
    fun findTimelineInit(request: TimelineGetRequest): List<TimelineBoardGetResult> {
        val boardsWithComment = boardRepository.findTimelineByBoardIds(
            fetchInitBoardIds(request)
        )

        return boardsWithComment.map {
            val writerName = userRepository.findById(it.board.id!!)
                .map { user -> user.username}
                .orElse("")

            val likeCount = fetchLikeCount(it.board.id!!)
            TimelineBoardGetResult.of(it, writerName, likeCount)
        }
    }

    fun findTimelineNext(request: TimelineGetRequest): List<TimelineBoardGetResult>{
        val boardsWithComment = boardRepository.findTimelineByBoardIds(
            fetchNextBoardIds(request)
        )

        return boardsWithComment.map {
            val writerName = userRepository.findById(it.board.id!!)
                .map { user -> user.username}
                .orElse("")

            val likeCount = fetchLikeCount(it.board.id!!)
            TimelineBoardGetResult.of(it, writerName, likeCount)
        }
    }

    fun findTimelinePrev(request: TimelineGetRequest): List<TimelineBoardGetResult> {
        val boardsWithComment = boardRepository.findTimelineByBoardIds(
            fetchPrevBoardIds(request)
        )

        return boardsWithComment.map {
            val writerName = userRepository.findById(it.board.id!!)
                .map { user -> user.username}
                .orElse("")

            val likeCount = fetchLikeCount(it.board.id!!)
            TimelineBoardGetResult.of(it, writerName, likeCount)
        }
    }

    private fun fetchInitBoardIds(request: TimelineGetRequest): List<Long> {
        return timelineService.requestTimelineInitBoardIds(request)
    }

    private fun fetchNextBoardIds(request: TimelineGetRequest): List<Long> {
        return timelineService.requestTimelineNextBoardIds(request)
    }

    private fun fetchPrevBoardIds(request: TimelineGetRequest): List<Long> {
        return timelineService.requestTimelinePrevBoardIds(request)
    }

    private fun fetchLikeCount(targetBoardId: Long): Long {
        return likeApiService.fetchLikeCounts(targetBoardId)
    }
}