package com.example.frontServer.service.noti

import com.example.frontServer.dto.notification.request.NotificationSaveRequest
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class NotificationKafkaProducer(
    private val kafkaTemplate: KafkaTemplate<String, Any>
) {
    private val logger = KotlinLogging.logger {}
    private val topic = "noti"

    fun sendNotifications(requests: List<NotificationSaveRequest>) {
        requests.forEach { request ->
            kafkaTemplate.send(topic, request)
        }
        logger.info { "send request to Kafka server finished!" }
    }

    fun testKafkaPublish(message: String) {
        kafkaTemplate.send("test", message)
        logger.info { "send message to kafka broker!! "}
    }
}