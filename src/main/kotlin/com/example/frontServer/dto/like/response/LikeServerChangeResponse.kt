package com.example.frontServer.dto.like.response

import com.example.frontServer.dto.error.MSAServerErrorDetails

data class LikeServerChangeResponse(
    val result: LikeServerChangeResult,
    val errorCode: Int,
    val errorDetails: MSAServerErrorDetails?
)