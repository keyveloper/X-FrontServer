package com.example.frontServer.dto.auth

data class LoginResult(
    val id: Long,
    val jwtToken: String
)