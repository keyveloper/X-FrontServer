package com.example.frontServer.dto.board

import com.example.frontServer.entity.Board

// 단일 board에 대해
data class BoardWithComments(
    val board: Board,
    val comments: List<Board>
    ) {
    fun getCommentCount(): Int {
        return comments.size
    }
}