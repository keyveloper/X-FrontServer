package com.example.frontServer.dto.notification

import java.time.LocalDateTime

data class NotificationGetResult(
    val id: Long,

    val publisherName: String,

    val publisherImgUrl: String?,

    val receiverId: Long, // optional

    val message: String,

    val createdAt: LocalDateTime
) {
    companion object {
        fun of(
            serverResult: NotificationGetServerResult,
            publisherName: String,
            publisherImgUrl: String?,
            message: String
        ): NotificationGetResult {
            return NotificationGetResult(
                id = serverResult.id,
                publisherName = publisherName,
                publisherImgUrl = publisherImgUrl,
                receiverId = serverResult.receiverId,
                message = message,
                createdAt = serverResult.createdAt
            )
        }
    }
}