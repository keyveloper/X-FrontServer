package com.example.frontServer.dto.like.response

import com.example.frontServer.dto.error.MSAServerErrorDetails

data class LikeServerCountResponse(
    val result: LikeServerCountResult,
    val errorCode: Int,
    val errorDetails: MSAServerErrorDetails?
)