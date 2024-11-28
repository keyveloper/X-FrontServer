package com.example.frontServer.dto.timeline

import com.example.frontServer.dto.ErrorResponse
import com.example.frontServer.enum.FrontServerError

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