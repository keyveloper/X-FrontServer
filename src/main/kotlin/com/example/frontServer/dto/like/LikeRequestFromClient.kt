package com.example.frontServer.dto.like

import jakarta.validation.constraints.NotNull

data class LikeRequestFromClient(
    @field:NotNull
    val boardId: Long,

    @field:NotNull
    val userId: Long,

    @field:NotNull
    val likeType: Int
)