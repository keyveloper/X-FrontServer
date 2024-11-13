package com.example.frontServer.dto.user

import java.time.LocalDate
import java.time.LocalDateTime
//
data class UserResponse(
    val email: String,
    val username: String,
    val introduction: String?,
    val birthday: LocalDate?,
    val accountCreatingDay: LocalDateTime,
    val country: String?,
) {
    companion object {
        fun of(request: UserResult): UserResponse {
            return UserResponse(
                email = request.email,
                username = request.username,
                introduction = request.introduction,
                birthday = request.birthday,
                accountCreatingDay = request.firstMadeDate,
                country = request.country,
            )
        }
    }
}