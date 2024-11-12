package com.example.frontServer.dto.board

import com.example.frontServer.dto.ServerErrorDetails
import com.example.frontServer.enum.FrontServerError

data class BoardResponseError(
    val details: ServerErrorDetails,
    val error: FrontServerError
)
