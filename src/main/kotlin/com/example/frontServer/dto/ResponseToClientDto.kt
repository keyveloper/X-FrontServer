package com.example.frontServer.dto

import com.example.frontServer.enum.ResponseCode

data class ResponseToClientDto(
    val errorCode: ResponseCode?,
    val data: Any?
    )
