package com.example.frontServer.dto.notification

import java.time.LocalDateTime

data class NotificationGetServerResult(
    val id: Long,

    val publisherId: Long,

    val receiverId: Long, // optional

    val message: String,

    val createdAt: LocalDateTime

)
