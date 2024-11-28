package com.example.frontServer.dto.timeline

data class TimelineRequest(
    val receiverId: Long,

    val startBoardId: Long,

    val endBoardId: Long,
)