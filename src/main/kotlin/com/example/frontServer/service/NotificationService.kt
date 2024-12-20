package com.example.frontServer.service

import com.example.frontServer.config.WebConfig
import com.example.frontServer.dto.error.ServerErrorDetails
import com.example.frontServer.dto.notification.*
import com.example.frontServer.enum.ServerResponseCode
import com.example.frontServer.repository.UserRepository
import io.github.oshai.kotlinlogging.KotlinLogging
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriBuilder

@Service
class NotificationService(
    private val webConfig: WebConfig,
    private val circuitBreakerRegistry: CircuitBreakerRegistry,
    private val userRepository: UserRepository,
    ) {
    private val circuitBreaker = circuitBreakerRegistry.circuitBreaker("notificationApiBreaker")
    private val logger = KotlinLogging.logger {}
    private val baseUrl = "http://localhost:8081"

    @CircuitBreaker(
        name = "notificationApiCircuitBreaker",
        fallbackMethod = "saveFallbackMethod"
    )

    // from board
    fun save(publisherId: Long, receiverIds: List<Long>, message: String, language: String): NotificationSaveServerResponse {
        val notiServerWebClient = webConfig.createWebClient(baseUrl, language)

        val response = notiServerWebClient.post()
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
            .retrieve()
            .bodyToMono(NotificationSaveServerResponse::class.java)
            .block()

        // response 처리 어떻게 해야하지 ?
        return response?: NotificationSaveServerResponse(
            savedRow = 0,
            errorDetails = ServerErrorDetails(
                type = "/notification/save",
                status = ServerResponseCode.FALLBACK,
                title = "response is null",
                detail = "noti api server sends null response, something sent wrong..."
            ),
            responseCode = ServerResponseCode.FALLBACK,
        )
    }

    @CircuitBreaker(
        name = "notificationApiCircuitBreaker",
        fallbackMethod = "getFallbackMethod"
    )
    fun fetchInitAll(receiverId: Long, language: String): List<NotificationGetResult>  {
        val notiServerWebClient = webConfig.createWebClient(baseUrl, language)
        val response = notiServerWebClient.post()
            .uri { uriBuilder: UriBuilder ->
                uriBuilder
                    .path("/notification/init")
                    .build()
            }
            .bodyValue(
                receiverId
            )
            .retrieve()
            .bodyToMono(NotificationGetServerResponse::class.java)
            .block()

        val results = response?.notificationGetServerResult ?: emptyList()

        return results.map {
            NotificationGetResult.of(it, findUserNameById(it.id), findUserImgUrlById(it.id))
        }
        // return noti server response
    }

    fun fetchPrevAll(getRequest: NotificationGetRequest, language: String): List<NotificationGetResult> {
        val notiServerWebClient = webConfig.createWebClient(baseUrl, language)

        val response = notiServerWebClient.post()
            .uri { uriBuilder: UriBuilder ->
                uriBuilder
                    .path("/notification/prev")
                    .build()
            }
            .bodyValue(getRequest)
            .retrieve()
            .bodyToMono(NotificationGetServerResponse::class.java)
            .block()

        val results = response?.notificationGetServerResult ?: emptyList()

        return results.map {
            NotificationGetResult.of(it, findUserNameById(it.id), findUserImgUrlById(it.id))
        }    }

    fun fetchNextAll(getRequest: NotificationGetRequest, language: String): List<NotificationGetResult> {
        val notiServerWebClient = webConfig.createWebClient(baseUrl, language)

        val response = notiServerWebClient.post()
            .uri { uriBuilder: UriBuilder ->
                uriBuilder
                    .path("/notification/next")
                    .build()
            }
            .bodyValue(
                getRequest
            )
            .retrieve()
            .bodyToMono(NotificationGetServerResponse::class.java)
            .block()

        val results = response?.notificationGetServerResult ?: emptyList()
        return results.map {
            NotificationGetResult.of(it, findUserNameById(it.id), findUserImgUrlById(it.id))
        }
    }

    private fun findUserNameById(id: Long): String{
        val user = userRepository.findById(id).orElse(null)
        return user.username
    }

    private fun findUserImgUrlById(id: Long): String? {
        return userRepository.findById(id).orElse(null).userImg
    }

    // fall back pattern : same parameter + Throwable , same return type,
    fun saveFallBackMethod(
        publisherId: Long,
        receiverIds: List<Long>,
        message: String,
        error: Throwable,
        language: String
    ): NotificationSaveServerResponse {
        logger.error {"run notification save fallback"}
        return NotificationSaveServerResponse(
            0,
            ServerErrorDetails(
                type = "/notification/save",
                status = ServerResponseCode.FALLBACK,
                title = "save fallback",
                detail = "noti api server dosen't work now",
            ),
            ServerResponseCode.SUCCESS
        )
    }

    fun getFallbackMethod(getRequest: NotificationGetRequest, language: String): List<NotificationGetServerResponse> {
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