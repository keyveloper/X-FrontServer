package com.example.frontServer.dto.board

import com.example.frontServer.entity.Board

// 전체 board에 대해
data class BoardWithCommentCount(
    val board: Board,
    val commentCount: Long,
)