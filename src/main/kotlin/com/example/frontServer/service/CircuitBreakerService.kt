package com.example.frontServer.service

import io.github.oshai.kotlinlogging.KotlinLogging
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry
import org.springframework.stereotype.Service

@Service
class CircuitBreakerService(
    private val likeService: LikeService
) {
    private val logger = KotlinLogging.logger {}



}