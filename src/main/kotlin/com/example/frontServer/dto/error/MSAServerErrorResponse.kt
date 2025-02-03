package com.example.frontServer.dto.error


open class MSAServerErrorResponse(
    open val errorDetails: MSAServerErrorDetails?,
    open val errorCode: Int
)