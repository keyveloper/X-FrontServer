package com.example.frontServer.dto.user

import java.time.LocalDate
import java.time.LocalDateTime

data class UserResponse(
    val email: String,
    val username: String,
    val introduction: String?,
    val birthday: LocalDate?,
    val firstMadeDate: LocalDateTime,
    val country: String?,
) {
    companion object{
        fun of(userResponse: UserResponse): UserResponse{
            return UserResponse(
                email = userResponse.email,
                username = userResponse.username,
                introduction = userResponse.introduction,
                birthday = userResponse.birthday,
                firstMadeDate = userResponse.firstMadeDate,
                country = userResponse.country,
            )
        }
    }
}