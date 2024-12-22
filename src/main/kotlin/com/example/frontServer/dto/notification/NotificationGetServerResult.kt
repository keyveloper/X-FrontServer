package com.example.frontServer.dto.notification

import com.example.frontServer.enum.NotificationType
import java.time.LocalDateTime

data class NotificationGetServerResult(
    val id: Long,

    val publisherId: Long,

    val receiverId: Long, // optional

    val notificationType: NotificationType,

    val createdAt: LocalDateTime,

    val targetBoardId: Long?
)
