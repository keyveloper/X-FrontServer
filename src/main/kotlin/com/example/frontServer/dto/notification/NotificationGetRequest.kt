package com.example.frontServer.dto.notification

data class NotificationGetRequest(
    val startId: Long,
    val endId: Long,
    val receiverId: Long,
)
