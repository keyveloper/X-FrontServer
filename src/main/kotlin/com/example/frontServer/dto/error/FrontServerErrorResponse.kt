package com.example.frontServer.dto.error

import com.example.frontServer.enum.FrontServerCode

open class FrontServerErrorResponse(
    open val responseCode: FrontServerCode
)