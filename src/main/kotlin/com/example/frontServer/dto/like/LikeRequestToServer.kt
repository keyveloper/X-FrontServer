package com.example.frontServer.dto.like


data class LikeRequestToServer(
    val boardId: Long,

    val userId: Long,

    val likeType: Int,
)