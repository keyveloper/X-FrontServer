package com.example.frontServer.service

import com.example.frontServer.dto.ResponseToServerDto
import com.example.frontServer.dto.ServerErrorDto
import com.example.frontServer.dto.UserSummaryDto
import io.github.oshai.kotlinlogging.KotlinLogging
import io.github.resilience4j.circuitbreaker.CircuitBreaker
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
    private val logger = KotlinLogging.logger {}
    private val circuitBreaker: CircuitBreaker = circuitBreakerRegistry.circuitBreaker("liveApiCircuitBreaker")

    fun save(boardId: Long, userId: Long): Boolean {
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
            .bodyToMono(ResponseToServerDto::class.java) // 응답이 String인 경우
            .block()

        if (response!!.error != null) {
            return false
        }
        return true
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

    private fun handleFallback(error: ServerErrorDto): Boolean {
        logger.error { error.toString() }
        return false
    }
}