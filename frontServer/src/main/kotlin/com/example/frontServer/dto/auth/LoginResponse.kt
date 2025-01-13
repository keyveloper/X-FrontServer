package com.example.frontServer.dto.auth

import com.example.frontServer.dto.error.MSAServerErrorDetails
import com.example.frontServer.dto.error.MSAServerErrorResponse
import com.example.frontServer.enum.MSAServerErrorCode

data class LoginResponse(
    val id: Long,
    val jwtToken : String?,
) {
    companion object {
        fun of(
            result: LoginResult,
        ): LoginResponse {
            return LoginResponse(
                id = result.id,
                jwtToken = result.jwtToken,
            )
        }
    }
}