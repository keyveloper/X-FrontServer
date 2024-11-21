package com.example.frontServer.dto.timeline

import com.example.frontServer.dto.ErrorResponse

data class TimelineBoardResponse(
    val timelineResult: TimelineBoardResult?,
    val errorResponse: ErrorResponse?
) {
    companion object {
        fun of(
            timelineResult: TimelineBoardResult?,
            errorResponse: ErrorResponse?
        ): TimelineBoardResponse {
            return TimelineBoardResponse(
                timelineResult = timelineResult,
                errorResponse = errorResponse
            )
        }
    }
}