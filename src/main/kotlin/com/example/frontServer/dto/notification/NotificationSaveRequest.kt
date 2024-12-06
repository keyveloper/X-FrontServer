package com.example.frontServer.dto.notification

data class NotificationSaveRequest(
    val publisherId: Long,

    val receiverId: Long,

    val message: String
)