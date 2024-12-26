package com.example.frontServer.dto.notification

import com.example.frontServer.dto.error.MSAServerErrorResponse
import com.example.frontServer.dto.error.MSAServerErrorDetails
import com.example.frontServer.enum.MSAServerErrorCode

class NotificationSaveServerResponse(
    val savedRow: Int,
    override val errorDetails: MSAServerErrorDetails?,
    override val responseCode: MSAServerErrorCode
): MSAServerErrorResponse(errorDetails, responseCode)