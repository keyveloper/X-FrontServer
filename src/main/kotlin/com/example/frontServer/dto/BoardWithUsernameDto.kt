package com.example.frontServer.dto

import com.example.frontServer.entity.Board

data class BoardWithUsernameDto(
    val board: Board,
    val username: String
)
