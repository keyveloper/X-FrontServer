package com.example.frontServer.dto.notification

import com.example.frontServer.dto.error.MSAServerErrorResponse
import com.example.frontServer.dto.error.MSAServerErrorDetails
import com.example.frontServer.enum.MSAServerErrorCode

data class NotificationGetServerResponse(
    // server response
    val notificationGetServerResults: List<NotificationGetServerResult>,
    override val errorDetails: MSAServerErrorDetails?,
    override val responseCode: MSAServerErrorCode
): MSAServerErrorResponse(errorDetails, responseCode)