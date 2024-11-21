package com.example.frontServer.dto.board

import com.example.frontServer.entity.Board

data class BoardWithComment(
    val board: Board,
    val comments: List<Board>
    ) {
    fun getCommentCount(): Int {
        return comments.size
    }
}