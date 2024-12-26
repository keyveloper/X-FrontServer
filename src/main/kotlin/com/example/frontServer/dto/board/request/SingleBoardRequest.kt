package com.example.frontServer.dto.board.request

import jakarta.validation.constraints.NotNull

data class SingleBoardRequest(
    @field: NotNull(message = "boardId is required")
    val boardId: Long
)