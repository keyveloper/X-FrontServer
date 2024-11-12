package com.example.frontServer.dto.like

import org.jetbrains.annotations.NotNull

data class LikeRequest(
    @field: NotNull
    val boardId: Long,
    @field: NotNull
    val userId: Long,
    @field: NotNull
    val likeType: Int,
)