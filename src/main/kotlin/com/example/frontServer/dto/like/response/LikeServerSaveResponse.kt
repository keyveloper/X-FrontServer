package com.example.frontServer.dto.like.response

import com.example.frontServer.dto.error.MSAServerErrorDetails

data class LikeServerSaveResponse(
    val result: LikeServerSaveResult,
    val errorCode: Int,
    val errorDetails: MSAServerErrorDetails?
)