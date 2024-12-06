package com.example.frontServer.service

import com.example.frontServer.dto.like.LikeRequestFromClient
import com.example.frontServer.dto.like.LikeRequestToServer
import com.example.frontServer.dto.like.LikeSaveResult
import com.example.frontServer.dto.like.LikeServerSaveResponse
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import io.github.oshai.kotlinlogging.KotlinLogging
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Service
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
        fallbackMethod = "saveFallbackMethod")
    fun save(likeRequest: LikeRequestFromClient, userId: Long) {
        val response = client.post()
            .uri { uriBuilder: UriBuilder ->
                uriBuilder
                    .path("/like")
                    .build()
            }
            .bodyValue(
                LikeRequestToServer(
                    boardId = likeRequest.boardId,
                    userId = userId,
                    likeType = likeRequest.likeType,
                )
            )
            .headers { headers ->
                headers.remove(HttpHeaders.AUTHORIZATION)
            }
            .retrieve()
            .bodyToMono(LikeServerSaveResponse::class.java)
            .block()
    }

    @CircuitBreaker(
        name = "liveApiCircuitBreaker",
        fallbackMethod = "findAllByBoardIdFallbackMethod"
    )
    fun findAllByBoardId(boardId: Long): List<Long>? {
        //"TODO"
        return null
    }

    // save 메서드의 fallbackMethod
    // 다시 만들기
    fun saveFallbackMethod(boardId: Long, userId: Long, throwable: Throwable): LikeSaveResult {
        logger.error { "Fallback called in save due to ${throwable.message}" }
        logCircuitBreakerInfo()
        return LikeSaveResult.of(
            LikeServerSaveResponse(
                error = null,
                details = null
            )
        )
    }

    // findAllByBoardId 메서드의 fallbackMethod
    fun findAllByBoardIdFallbackMethod(boardId: Long, throwable: Throwable): List<Long> {
        logger.error { "Fallback called in findAllByBoardId due to ${throwable.message}" }
        logCircuitBreakerInfo()
        return emptyList()
    }

    private fun logCircuitBreakerInfo() {
        val metrics = circuitBreaker.metrics

        logger.info { "CircuitBreaker state: ${circuitBreaker.state}" }
        logger.info { "Number of successful calls: ${metrics.numberOfSuccessfulCalls}" }
        logger.info { "Number of failed calls: ${metrics.numberOfFailedCalls}" }
        logger.info { "Failure rate: ${metrics.failureRate}%" }
    }
}