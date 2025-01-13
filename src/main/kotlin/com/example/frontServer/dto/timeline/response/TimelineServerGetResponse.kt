package com.example.frontServer.dto.timeline.response

import com.example.frontServer.dto.error.MSAServerErrorDetails
import com.example.frontServer.enum.MSAServerErrorCode

class TimelineServerGetResponse(
    val results: List<TimelineServerGetResult>,
    val errorDetails: MSAServerErrorDetails?,
    val errorCode: MSAServerErrorCode
)