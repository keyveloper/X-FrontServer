package com.example.frontServer.dto.error

import com.example.frontServer.enum.MSAServerErrorCode

open class MSAServerErrorResponse(
    open val errorDetails: MSAServerErrorDetails?,
    open val responseCode: MSAServerErrorCode
)