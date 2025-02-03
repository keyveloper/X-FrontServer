package com.example.frontServer.dto.auth

import com.example.frontServer.dto.error.FrontStatusDetailResponse
import com.example.frontServer.enum.StatusDetailCode

data class TokenValidationResponse(
    val id: Long?,
    override val statusDetailsCode: Long,
    override val message: String?,
): FrontStatusDetailResponse(statusDetailsCode = statusDetailsCode, message = message)