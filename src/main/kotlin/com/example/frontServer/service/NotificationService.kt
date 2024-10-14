package com.example.frontServer.service

import com.example.frontServer.dto.NotificationDto
import com.example.frontServer.dto.NotificationInfo
import com.example.frontServer.entity.Notification
import com.example.frontServer.repository.NotificationRepository
import org.springframework.stereotype.Service

@Service
class NotificationService(
    private val notificationRepository: NotificationRepository
) {
    fun save(notificationInfo: NotificationInfo): Boolean {
        val receivers = notificationInfo.receivers
        val notifications: List<Notification> = receivers.map {makeBoardNotification(
            notificationInfo.contentImg,
            it,
            notificationInfo.message
        )}

        notificationRepository.saveAll(notifications)
        return true
    }

    private fun makeBoardNotification(
        publisherImg: String?,
        receiver: Long,
        message: String
    ): Notification {
        return Notification(
            publisherImg = publisherImg,
            receiver = receiver,
            message = message,
        )
    }

    fun findAllByReceiver(receiver: Long): List<NotificationDto> {
        return notificationRepository.findAllByReceiver(receiver).map {
            NotificationDto(
                message = it.message,
                createAt = it.createAt!!, // neve null - spring injected
                publisherImg = it.publisherImg,
            )
        }
    }
}