package com.example.frontServer.service

import com.example.frontServer.dto.TimelineBoardListDto
import com.example.frontServer.entity.Timeline
import com.example.frontServer.repository.BoardRepository
import com.example.frontServer.repository.TimelineRepository
import org.springframework.stereotype.Service

@Service
class TimelineService(
    private val timelineRepository: TimelineRepository,
    private val boardRepository: BoardRepository
) {
    fun findAllByReceiverId(receiverId: Long): TimelineBoardListDto {
        return TimelineBoardListDto.of(timelineRepository.findAllByReceiverIdWithInOneDay(receiverId))
        // 여기서 board에 해당하는 data를 보내는걸로 하자.
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