package com.example.frontServer.dto

import com.example.frontServer.enum.FrontServerCode

open class ErrorResponse(
    var code: FrontServerCode,
    var message: String?
)