package com.example.frontServer.dto.user.response

//
data class UserProfileGetResponse(
    val result: UserProfileGetResult,
) {
    companion object {
        fun of(result: UserProfileGetResult): UserProfileGetResponse {
            return UserProfileGetResponse(
                result = result,
            )
        }
    }
}