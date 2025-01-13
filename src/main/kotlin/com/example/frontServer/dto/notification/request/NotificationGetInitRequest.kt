package com.example.frontServer.dto.notification.request

import jakarta.validation.constraints.NotNull

class NotificationGetInitRequest(
    @field: NotNull
    val receiverId: Long
)