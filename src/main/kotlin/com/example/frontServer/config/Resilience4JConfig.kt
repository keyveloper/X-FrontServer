package com.example.frontServer.config

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.Duration

@Configuration
class Resilience4JConfig {
    @Bean
    fun circuitBreakerRegistry(): CircuitBreakerRegistry {
        val circuitBreakerConfig = CircuitBreakerConfig.custom()
            .failureRateThreshold(50f)
            .waitDurationInOpenState(Duration.ofMinutes(1000))
            .permittedNumberOfCallsInHalfOpenState(3)
            .slidingWindowSize(10)
            .build()

        return CircuitBreakerRegistry.of(circuitBreakerConfig)
    }
}