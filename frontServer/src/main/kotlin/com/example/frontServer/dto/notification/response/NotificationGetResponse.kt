package com.example.frontServer.dto.notification.response

data class NotificationGetResponse(
    // response to client from front
    val results: List<NotificationGetResult>,
) {
    companion object {
        fun of(results: List<NotificationGetResult>): NotificationGetResponse {
            return NotificationGetResponse(
                results = results,
            )
        }
    }
}