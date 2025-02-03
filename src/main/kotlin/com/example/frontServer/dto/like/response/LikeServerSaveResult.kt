package com.example.frontServer.dto.like.response

data class LikeServerSaveResult(
    val isSave: Boolean,
    val id: Long?,
    val targetBoardId: Long?,
)