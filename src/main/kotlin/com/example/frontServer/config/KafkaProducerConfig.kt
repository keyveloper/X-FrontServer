package com.example.frontServer.config

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*

@Configuration
class KafkaProducerConfig {

    /**
     * Producer에 필요한 Properties를 Bean으로 등록
     */
    @Bean
    fun kafkaProducerProperties(): Properties {
        return Properties().apply {
            // Kafka 브로커 주소
            put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.17.79:9092")

            // 문자열 직렬화
            put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer::class.java.name)
            put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer::class.java.name)

            // acks 설정 등 원하는 옵션 추가 가능
            put(ProducerConfig.ACKS_CONFIG, "1")
            // 필요한 경우 retries, batch.size, linger.ms 등도 설정
        }
    }

    /**
     * KafkaProducer를 Bean으로 등록
     */
    @Bean
    fun kafkaProducer(kafkaProducerProperties: Properties): KafkaProducer<String, String> {
        return KafkaProducer(kafkaProducerProperties)
    }
}
