package com.example.frontServer.dto.notification.response

data class NotificationSaveResponse(
    val savedRow: Int,
) {
    companion object {
        fun of(serverResponse: NotificationServerSaveResponse): NotificationSaveResponse {
            return NotificationSaveResponse(
                savedRow = serverResponse.savedRow,
            )
        }
    }
}