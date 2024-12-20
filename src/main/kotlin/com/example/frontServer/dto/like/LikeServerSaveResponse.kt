package com.example.frontServer.dto.like

import com.example.frontServer.dto.error.ServerErrorDetails
import com.example.frontServer.enum.ServiceServerError

data class LikeServerSaveResponse(
    val error: ServiceServerError?,
    val details: ServerErrorDetails?
)