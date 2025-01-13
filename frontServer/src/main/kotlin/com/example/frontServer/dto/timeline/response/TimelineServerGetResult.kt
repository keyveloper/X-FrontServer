package com.example.frontServer.dto.timeline.response

import java.time.LocalDateTime

data class TimelineServerGetResult(
    val id: Long,
    val boardId: Long,
    val createdAt: LocalDateTime,
)