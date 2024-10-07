package com.example.frontServer.service

import com.example.frontServer.dto.ResponseToServerDto
import com.example.frontServer.dto.UserSummaryDto
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import com.example.frontServer.exception.FallbackFailureException
import io.github.oshai.kotlinlogging.KotlinLogging
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriBuilder

@Service
class LikeService(
    private val client : WebClient,
    private val circuitBreakerRegistry: CircuitBreakerRegistry

) {
    private val circuitBreaker = circuitBreakerRegistry.circuitBreaker("liveApiCircuitBreaker")
    private val logger = KotlinLogging.logger {}
    @CircuitBreaker(
        name = "liveApiCircuitBreaker",
        fallbackMethod = "fallbackMethod",)
    fun save(boardId: Long, userId: Long): Boolean {
       return try {
           val response = client.post()
               .uri { uriBuilder: UriBuilder ->
                   uriBuilder
                       .path("/live/like")
                       .queryParam("boardId", boardId)
                       .queryParam("userId", userId)
                       .build()
               }
               .headers { headers ->
                   headers.remove(HttpHeaders.AUTHORIZATION)
               }
               .retrieve()
               .bodyToMono(ResponseToServerDto::class.java)
               .block()

           if (response?.error != null) {
               logCircuitBreakerInfo()
               throw FallbackFailureException("Response contains an error: ${response.error}")
           }
           logCircuitBreakerInfo()
           true
       } catch (ex: FallbackFailureException) {
           logger.error {ex.message}
           false
       }
    }

    @Transactional(readOnly = true)
    fun findUserLikeThisBoard(boardId: Long): List<UserSummaryDto>? {
        return client.get()
            .uri { uriBuilder: UriBuilder ->
                uriBuilder
                    .path("/like/users")
                    .queryParam("boardId", boardId)
                    .build()
            }
            .retrieve()
            .bodyToMono(object: ParameterizedTypeReference<List<UserSummaryDto>>() {})
            .block()
    }

    private fun fallbackMethod(boardId: Long, userId: Long, throwable: Throwable): Boolean {
        logger.error { "Fallback called due to ${throwable.message}"}
        logCircuitBreakerInfo()

        throw FallbackFailureException("Fallback method executed, marking as failure")
    }

    private fun logCircuitBreakerInfo() {
        val metrics = circuitBreaker.metrics

        logger.info { "CircuitBreaker state: ${circuitBreaker.state}" }
        logger.info { "Number of successful calls: ${metrics.numberOfSuccessfulCalls}" }
        logger.info { "Number of failed calls: ${metrics.numberOfFailedCalls}" }
        logger.info { "Failure rate: ${metrics.failureRate}%" }
    }

}