package com.example.frontServer.dto.notification

import com.example.frontServer.dto.error.FrontServerErrorResponse

data class NotificationSaveResponse(
    val savedRow: Int,
    override val responseCode: FrontServerCode
): FrontServerErrorResponse(responseCode) {
    companion object {
        fun of(
            serverResponse: NotificationSaveServerResponse,
            responseCode: FrontServerCode
        ): NotificationSaveResponse {
            return NotificationSaveResponse(
                savedRow = serverResponse.savedRow,
                responseCode = responseCode
            )
        }
    }
}