package com.example.frontServer.service.noti

import com.example.frontServer.dto.notification.request.NotificationSaveRequest
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.github.oshai.kotlinlogging.KotlinLogging
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.springframework.stereotype.Service

@Service
class KafkaProducerService(
    private val kafkaProducer: KafkaProducer<String, String>
) {
    private val logger = KotlinLogging.logger {}
    private val objectMapper = jacksonObjectMapper()

    fun sendNoti(request: NotificationSaveRequest) {
        val topicName = "noti" // 예: Consumer가 구독 중인 동일 토픽
        try {
            // DTO를 JSON 문자열로 직렬화
            val jsonValue = objectMapper.writeValueAsString(request)

            // ProducerRecord 생성 후 send
            val record = ProducerRecord<String, String>(topicName, jsonValue)
            kafkaProducer.send(record) { metadata, exception ->
                if (exception == null) {
                    logger.info {
                        "Sent message to $topicName [offset=${metadata.offset()}, " +
                                "partition=${metadata.partition()}]" }
                } else {
                    logger.error { "Failed to send message: ${exception.message}" }
                }
            }
        } catch (e: Exception) {
            logger.error { "sendMessage error: ${e.message}" }
        }
    }
}