package com.example.frontServer.dto.timeline

class TimelineBoardResponse(
    val timelineBoardResult: TimelineBoardResult,
) {
    companion object {
        fun of(
            timelineBoardResult: TimelineBoardResult,
        ): TimelineBoardResponse {
            return TimelineBoardResponse(
                timelineBoardResult = timelineBoardResult,
            )
        }
    }
}