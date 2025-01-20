package com.example.frontServer.dto.auth

import com.example.frontServer.dto.error.FrontStatusDetailResponse
import com.example.frontServer.enum.StatusDetailCode

data class SignUpResponse(
    override val statusDetailsCode: StatusDetailCode,
    override val message: String?
): FrontStatusDetailResponse(statusDetailsCode = statusDetailsCode, message = message)