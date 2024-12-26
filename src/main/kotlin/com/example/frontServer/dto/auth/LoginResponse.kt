package com.example.frontServer.dto.auth

data class LoginResponse(
    val jwtToken : String?,
    val errorResponse: ErrorResponse?
) {
    companion object {
        fun of(result: LoginResult, error: ErrorResponse?): LoginResponse {
            return LoginResponse(
                jwtToken = result.jwtToken,
                errorResponse = error
            )
        }
    }
}