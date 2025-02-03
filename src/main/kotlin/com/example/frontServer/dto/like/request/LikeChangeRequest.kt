package com.example.frontServer.dto.like.request

import com.example.frontServer.enum.LikeType

data class LikeChangeRequest(
    val userId: Long,
    val boardId: Long,
    val type: LikeType
)