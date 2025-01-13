package com.example.frontServer.dto.notification.request

data class NotificationGetRequest(
    val startId: Long,
    val endId: Long,
    val receiverId: Long,
)
