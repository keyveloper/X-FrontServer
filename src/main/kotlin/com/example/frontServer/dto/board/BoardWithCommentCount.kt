package com.example.frontServer.dto.board

import com.example.frontServer.entity.Board

data class BoardWithCommentCount(
    val board: Board,
    val commentCount: Long,
)