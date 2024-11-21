package com.example.frontServer.dto

import com.example.frontServer.enum.FrontServerError

open class ErrorResponse(
    var code: FrontServerError,
    var message: String?
)