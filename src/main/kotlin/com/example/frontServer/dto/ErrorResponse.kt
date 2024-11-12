package com.example.frontServer.dto

import com.example.frontServer.enum.FrontServerError

data class ErrorResponse(
    val code: FrontServerError,
    val message: String?
)