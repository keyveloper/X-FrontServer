package com.example.frontServer.service

import com.example.frontServer.dto.NotificationDto
import com.example.frontServer.dto.notification.NotificationGetRequest
import com.example.frontServer.dto.notification.NotificationGetServerResponse
import com.example.frontServer.dto.notification.NotificationSaveRequest
import com.example.frontServer.dto.notification.NotificationSaveServerResponse
import com.example.frontServer.entity.Notification
import io.github.oshai.kotlinlogging.KotlinLogging
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriBuilder

@Service
class NotificationService(
    private val client: WebClient,
    private val circuitBreakerRegistry: CircuitBreakerRegistry
    ) {
    private val circuitBreaker = circuitBreakerRegistry.circuitBreaker("notificationApiBreaker")
    private val logger = KotlinLogging.logger {}
    @CircuitBreaker(
        name = "notificationApiCircuitBreaker",
        fallbackMethod = "saveFallbackMethod"
    )
    fun save(publisherId: Long, receiverIds: List<Long>, message: String): NotificationSaveServerResponse {
        val response = client.post()
            .uri { uriBuilder: UriBuilder ->
                uriBuilder
                    .path("/notification/save")
                    .build()
            }
            .bodyValue(
                receiverIds.map {
                    NotificationSaveRequest(
                        publisherId = publisherId,
                        receiverId = it,
                        message = message
                    )
                }
            )
    }

    @CircuitBreaker(
        name = "notificationApiCircuitBreaker",
        fallbackMethod = "getFallbackMethod"
    )
    fun fetchInitAll(receiverId: Long): List<NotificationGetServerResponse>  {
        val response = client.post()
            .uri { uriBuilder: UriBuilder ->
                uriBuilder
                    .path("/notification/init")
                    .build()
            }
            .bodyValue(
                receiverId
            )

        // return noti server response
    }

    fun fetchPrevAll(getRequest: NotificationGetRequest): List<NotificationGetServerResponse> {
        val response = client.post()
            .uri { uriBuilder: UriBuilder ->
                uriBuilder
                    .path("/notification/prev")
                    .build()
            }
            .bodyValue(
                getRequest
            )
    }

    fun fetchNextAll(getRequest: NotificationGetRequest): List<NotificationGetServerResponse> {
        val response = client.post()
            .uri { uriBuilder: UriBuilder ->
                uriBuilder
                    .path("/notification/next")
                    .build()
            }
            .bodyValue(
                getRequest
            )
    }

    // fall back pattern : same parameter + Throwable , same return type,
    fun saveFallBackMethod(
        publisherId: Long,
        receiverIds: List<Long>,
        message: String,
        error: Throwable
    ): NotificationSaveServerResponse {
        logger.error {"run notification save fallback"}
        return NotificationSaveServerResponse()
    }

    fun getFallbackMethod(getRequest: NotificationGetRequest): List<NotificationGetServerResponse> {
        logger.error {"run notification get fallback"}
        return listOf()
    }

    private fun logCircuitBreakerInfo() {
        val metrics = circuitBreaker.metrics

        logger.info { "CircuitBreaker state: ${circuitBreaker.state}" }
        logger.info { "Number of successful calls: ${metrics.numberOfSuccessfulCalls}" }
        logger.info { "Number of failed calls: ${metrics.numberOfFailedCalls}" }
        logger.info { "Failure rate: ${metrics.failureRate}%" }
    }
}