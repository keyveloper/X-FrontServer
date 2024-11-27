package com.example.frontServer.dto.timeline

import com.example.frontServer.dto.ErrorResponse
import com.example.frontServer.enum.FrontServerError

data class TimelineBoardResponse(
    val timelineBoardResult: TimelineBoardResult,
): ErrorResponse(FrontServerError.OK, null) {
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