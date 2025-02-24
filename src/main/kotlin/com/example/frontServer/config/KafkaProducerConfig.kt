package com.example.frontServer.config

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import java.util.*

@Configuration
class KafkaProducerConfig {

    @Bean
    fun kafkaProducer(
        @Value("\${spring.kafka.bootstrap-servers}") kafkaBootstrapServers: String,
        @Value("\${spring.kafka.producer.key-serializer}") keySerializer: String,
        @Value("\${spring.kafka.producer.value-serializer}") valueSerializer: String
    ): KafkaProducer<String, String> {
        val props = Properties().apply {
            put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBootstrapServers)
            put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, keySerializer)
            put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, valueSerializer)
        }
        return KafkaProducer<String, String>(props)
    }
}