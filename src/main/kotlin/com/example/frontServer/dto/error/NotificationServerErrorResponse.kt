package com.example.frontServer.dto.error

import com.example.frontServer.enum.ServerResponseCode

open class NotificationServerErrorResponse(
    open val errorDetails: ServerErrorDetails?,
    open val responseCode: ServerResponseCode
)