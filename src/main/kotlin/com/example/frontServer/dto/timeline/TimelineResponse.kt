package com.example.frontServer.dto.timeline

import com.example.frontServer.dto.ErrorResponse

data class TimelineResponse(
    val timelineResult: TimelineResult?,
    val errorResponse: ErrorResponse?
) {
    companion object {
        fun of(
            timelineResult: TimelineResult?,
            errorResponse: ErrorResponse?
        ): TimelineResponse {
            return TimelineResponse(
                timelineResult = timelineResult,
                errorResponse = errorResponse
            )
        }
    }
}