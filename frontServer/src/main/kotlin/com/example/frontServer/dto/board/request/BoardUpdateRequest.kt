package com.example.frontServer.dto.board.request

data class BoardUpdateRequest(
    val boardId: Long,
    val textContent: String,
)
