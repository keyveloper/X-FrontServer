package com.example.frontServer.dto

import com.example.frontServer.entity.Timeline

data class TimelineBoardListDto(
    val receiverId: Long,
    val boardIds: List<Long>
) {
    companion object{
        fun of(timelines: List<Timeline>): TimelineBoardListDto {
            return TimelineBoardListDto(
                receiverId = timelines.get(0).receiverId,
                boardIds = timelines.map {it.boardId}
            )
        }
    }
}