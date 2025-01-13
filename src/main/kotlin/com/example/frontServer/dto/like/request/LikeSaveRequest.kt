package com.example.frontServer.dto.like.request

import com.example.frontServer.enum.LikeType
import jakarta.validation.constraints.NotNull

data class LikeSaveRequest(
    @field:NotNull
    val boardId: Long,

    @field:NotNull
    val userId: Long,

    @field:NotNull
    val likeType: LikeType
)