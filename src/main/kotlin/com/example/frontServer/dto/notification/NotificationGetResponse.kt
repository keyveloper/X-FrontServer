package com.example.frontServer.dto.notification

import com.example.frontServer.dto.error.FrontServerErrorResponse
import com.example.frontServer.enum.FrontServerCode

data class NotificationGetResponse(
    // response to client from front
    val notificationGetResult: List<NotificationGetResult>,
    override val responseCode: FrontServerCode
): FrontServerErrorResponse(responseCode) {
    companion object {
        fun of(
            results: List<NotificationGetResult>,
            responseCode: FrontServerCode
        ): NotificationGetResponse {
            return NotificationGetResponse(
                notificationGetResult = results,
                responseCode = responseCode
            )
        }
    }
}