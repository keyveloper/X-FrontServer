package com.example.frontServer

import org.apache.kafka.clients.producer.KafkaProducer
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")
class FrontServer1ApplicationTests {

    @Test
    fun contextLoads() {
    }
}
