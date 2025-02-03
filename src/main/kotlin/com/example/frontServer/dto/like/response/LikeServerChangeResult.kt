package com.example.frontServer.dto.like.response

data class LikeServerChangeResult(
    val isChange: Boolean,
    val likeId: Long?,
    val boardId: Long?,
    val changedType: Int?,
)