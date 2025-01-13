package com.example.frontServer.dto.timeline.response

class TimelineBoardGetResponse(
    val results: List<TimelineBoardGetResult>,
) {
    companion object {
        fun of(
            timelineBoardResults: List<TimelineBoardGetResult>,
        ): TimelineBoardGetResponse {
            return TimelineBoardGetResponse(
                results = timelineBoardResults,
            )
        }
    }
}