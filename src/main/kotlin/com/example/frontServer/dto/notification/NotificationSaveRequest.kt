package com.example.frontServer.dto.notification

import com.example.frontServer.enum.NotificationType

data class NotificationSaveRequest(
    val publisherId: Long,

    val receiverId: Long,

    val notificationType: NotificationType,

    val targetBoardId: Long?
)