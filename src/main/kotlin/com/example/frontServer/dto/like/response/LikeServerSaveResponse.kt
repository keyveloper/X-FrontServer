package com.example.frontServer.dto.like.response

import com.example.frontServer.dto.error.MSAServerErrorDetails
import com.example.frontServer.enum.MSAServerErrorCode

data class LikeServerSaveResponse(
    val errorCode: MSAServerErrorCode,
    val errorDetails: MSAServerErrorDetails?
)