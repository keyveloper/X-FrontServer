package com.example.frontServer.dto.like.response

import com.example.frontServer.dto.error.FrontStatusDetailResponse

data class LikeChangeResponse(
    val result: LikeChangeResult,
    override val statusDetailsCode: Long,
    override val message: String?
): FrontStatusDetailResponse(statusDetailsCode, message) {
    companion object {
        fun of(
            result: LikeChangeResult,
            statusDetailsCode: Long,
            message: String?): LikeChangeResponse {
            return LikeChangeResponse(
                result = result,
                statusDetailsCode = statusDetailsCode,
                message = message
            )
        }
    }
}