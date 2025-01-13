package com.example.frontServer.dto.notification.response

import com.example.frontServer.dto.error.MSAServerErrorResponse
import com.example.frontServer.dto.error.MSAServerErrorDetails
import com.example.frontServer.enum.MSAServerErrorCode

class NotificationServerSaveResponse(
    val savedRow: Int,
    override val errorDetails: MSAServerErrorDetails?,
    override val errorCode: MSAServerErrorCode
): MSAServerErrorResponse(errorDetails, errorCode)