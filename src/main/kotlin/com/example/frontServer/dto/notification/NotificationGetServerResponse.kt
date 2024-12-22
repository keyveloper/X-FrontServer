package com.example.frontServer.dto.notification

import com.example.frontServer.dto.error.NotificationServerErrorResponse
import com.example.frontServer.dto.error.ServerErrorDetails
import com.example.frontServer.enum.ServerResponseCode

data class NotificationGetServerResponse(
    // server response
    val notificationGetServerResults: List<NotificationGetServerResult>,
    override val errorDetails: ServerErrorDetails?,
    override val responseCode: ServerResponseCode
): NotificationServerErrorResponse(errorDetails, responseCode)