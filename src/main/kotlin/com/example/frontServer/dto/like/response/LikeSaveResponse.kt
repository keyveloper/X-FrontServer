package com.example.frontServer.dto.like.response

import com.example.frontServer.dto.error.FrontStatusDetailResponse

data class LikeSaveResponse(
    val result: LikeSaveResult,
    override val statusDetailsCode: Long,
    override val message: String?
): FrontStatusDetailResponse(statusDetailsCode = statusDetailsCode, message = message) {
    companion object {
        fun of(
            result: LikeSaveResult,
            statusDetailsCode: Long,
            message: String?
        ): LikeSaveResponse {
            return LikeSaveResponse(
                result = result,
                statusDetailsCode = statusDetailsCode,
                message = message
            )
        }
    }
}