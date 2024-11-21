package com.example.frontServer.dto.board

import com.example.frontServer.entity.Board
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

data class BoardWithComment(
    val board: Board,
    val comments: List<Board>
    ) {
    fun getCommentCount(): Int {
        return comments.size
    }
}