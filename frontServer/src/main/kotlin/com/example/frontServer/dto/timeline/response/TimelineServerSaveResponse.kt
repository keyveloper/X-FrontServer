package com.example.frontServer.dto.timeline.response

import com.example.frontServer.dto.error.MSAServerErrorDetails
import com.example.frontServer.enum.MSAServerErrorCode

class TimelineServerSaveResponse(
    val errorDetails: MSAServerErrorDetails?,
    val errorCode: MSAServerErrorCode
)