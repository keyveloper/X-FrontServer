package com.example.frontServer.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.ProducerFactory
import org.springframework.kafka.core.KafkaTemplate


@EnableKafka
@Configuration
class KafkaProducerConfig {

    @Bean
    fun producerFactory(): ProducerFactory<String, Any> {
        val configProps: MutableMap<String, Any> = HashMap()
        configProps["bootstrap.servers"] = "localhost:9092"
        configProps["key.serializer"] = "org.apache.kafka.common.serialization.StringSerializer"
        // 값(value)에 대해서는 JSON 직렬화를 사용
        configProps["value.serializer"] = "org.springframework.kafka.support.serializer.JsonSerializer"
        configProps["spring.json.trusted.packages"] = "*"

        return DefaultKafkaProducerFactory(configProps)
    }


    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, Any> {
        return KafkaTemplate(producerFactory())
    }
}