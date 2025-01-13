package com.example.frontServer.dto.notification.response

import java.time.LocalDateTime

data class NotificationGetResult(
    val notiId: Long,

    val publisherName: String,

    val publisherImgUrl: String?,

    val publisherId: Long,

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
                notiId = serverResult.id,
                publisherName = publisherName,
                publisherImgUrl = publisherImgUrl,
                publisherId = serverResult.publisherId,
                message = message,
                createdAt = serverResult.createdAt
            )
        }
    }
}