package com.example.frontServer.dto.like.response

import com.example.frontServer.dto.error.FrontStatusDetailResponse

data class LikeCountResponse(
    val result: LikeCountResult,
    override val statusDetailsCode: Long,
    override val message: String
): FrontStatusDetailResponse(statusDetailsCode, message) {
    companion object {
        fun of(
            result: LikeCountResult,
            statusDetailsCode: Long,
            message: String
        ): LikeCountResponse {
            return LikeCountResponse(
                result,
                statusDetailsCode,
                message
            )
        }
    }
}
