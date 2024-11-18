package com.example.frontServer.dto.timeline

import java.time.LocalDateTime

data class TimelineSearchPolicy(
    val receiverId: Long,

    val lastSeenId: Long,

    val currentTime: LocalDateTime,

    val pageSize: Long,
)