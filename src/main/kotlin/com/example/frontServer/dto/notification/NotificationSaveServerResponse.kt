package com.example.frontServer.dto.notification

import com.example.frontServer.dto.error.NotificationServerErrorResponse
import com.example.frontServer.dto.error.ServerErrorDetails
import com.example.frontServer.enum.ServerResponseCode

class NotificationSaveServerResponse(
    val savedRow: Int,
    override val errorDetails: ServerErrorDetails?,
    override val responseCode: ServerResponseCode
): NotificationServerErrorResponse(errorDetails, responseCode)