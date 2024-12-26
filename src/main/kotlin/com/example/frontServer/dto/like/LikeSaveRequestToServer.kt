package com.example.frontServer.dto.like

import com.example.frontServer.enum.LikeType


data class LikeSaveRequestToServer(
    val boardId: Long,

    val userId: Long,

    val likeType: LikeType,
)