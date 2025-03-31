package com.example.frontServer.service.noti

import com.example.frontServer.config.WebConfig
import com.example.frontServer.dto.notification.request.NotificationGetRequest
import com.example.frontServer.dto.notification.response.NotificationGetResult
import com.example.frontServer.dto.notification.response.NotificationGetServerResponse
import com.example.frontServer.repository.board.BoardRepository
import com.example.frontServer.repository.user.UserRepository
import io.github.oshai.kotlinlogging.KotlinLogging
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.util.UriBuilder

@Service
class NotificationApiService(
    private val webConfig: WebConfig,
    private val circuitBreakerRegistry: CircuitBreakerRegistry,
    private val userRepository: UserRepository,
    private val boardRepository: BoardRepository,
    private val messageService: MessageService,
    ) {
    private val circuitBreaker = circuitBreakerRegistry.circuitBreaker("notificationApiCircuitBreaker")
    private val logger = KotlinLogging.logger {}
    private val baseUrl = "http://x-noti-api-service:8080"

    @CircuitBreaker(
        name = "notificationApiCircuitBreaker",
        fallbackMethod = "getInitFallbackMethod"
    )
    @Transactional
    fun fetchInitAll(receiverId: Long, language: String): List<NotificationGetResult> {
        logger.info { "fetchInit start ${receiverId}, $language" }
        val notiServerWebClient = webConfig.createWebClient(baseUrl)
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
            .onStatus({ it.isError }) { clientResponse ->
                // HTTP 상태코드가 에러일 때 처리
                clientResponse.bodyToMono(String::class.java).flatMap { errorBody ->
                    // 이곳에서 에러 내용 로깅
                    logger.error { "HTTP Error: ${clientResponse.statusCode()} / Body: $errorBody" }
                    throw RuntimeException("HTTP Error: ${clientResponse.statusCode()} - $errorBody")
                }
            }
            .bodyToMono(NotificationGetServerResponse::class.java)
            .block()

        val results = response?.serverResults ?: emptyList()
        logger.info { "response: $results" }

        return try {
            results.map {
                // make message by result's parameter
                val username = findUserNameById(it.publisherId)
                val imgUrl = findUserImgUrlById(it.publisherId)
                val targetBoard = it.targetBoardId?.let { id ->
                    boardRepository.findById(id).orElse(null)
                }
                logger.info {"make message start! ${username}, ${imgUrl}, $targetBoard"}
                val message = messageService.makeMessage(
                    it.notificationType, targetBoard, targetBoard?.id, username, language
                )
                logger.info {"mssage: $message"}
                NotificationGetResult.of(it, username, imgUrl, message)
            }
        } catch (e: Exception) {
            throw e
        }
        // return noti server response
    }

    @Transactional
    @CircuitBreaker(
        name = "notificationApiCircuitBreaker",
        fallbackMethod = "getScrollFallbackMethod"
    )
    // circuit 연결
    fun fetchPrevAll(getRequest: NotificationGetRequest, language: String): List<NotificationGetResult> {
        val notiServerWebClient = webConfig.createWebClient(baseUrl)

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

        val results = response?.serverResults ?: emptyList()

        return results.map {
            val username = findUserNameById(it.publisherId)
            val imgUrl = findUserImgUrlById(it.publisherId)
            val targetBoard = it.targetBoardId?.let { id ->
                boardRepository.findById(id).orElse(null)
            }
            logger.info {"make message start! ${username}, ${imgUrl}, $targetBoard"}
            val message = messageService.makeMessage(
                it.notificationType, targetBoard, targetBoard?.id, username, language
            )
            NotificationGetResult.of(it, username, imgUrl, message)
        }
    }

    @Transactional
    @CircuitBreaker(
        name = "notificationApiCircuitBreaker",
        fallbackMethod = "getScrollFallbackMethod"
    )
    // circuit 연결
    fun fetchNextAll(getRequest: NotificationGetRequest, language: String): List<NotificationGetResult> {
        val notiServerWebClient = webConfig.createWebClient(baseUrl)

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

        val results = response?.serverResults ?: emptyList()
        return results.map {
            val username = findUserNameById(it.publisherId)
            val imgUrl = findUserImgUrlById(it.publisherId)
            val targetBoard = it.targetBoardId?.let { id ->
                boardRepository.findById(id).orElse(null)
            }
            logger.info {"make message start! ${username}, ${imgUrl}, $targetBoard"}
            val message = messageService.makeMessage(
                it.notificationType, targetBoard, targetBoard?.id, username, language
            )
            NotificationGetResult.of(it, username, imgUrl, message)
        }
    }

    private fun findUserNameById(id: Long): String{
        val user = userRepository.findById(id).orElse(null)
        return user?.username ?: "UnKnown User"
    }

    private fun findUserImgUrlById(id: Long): String? {
        return userRepository.findById(id).orElse(null).userImg
    }

    @CircuitBreaker(
        name = "notificationApiCircuitBreaker",
        fallbackMethod = "testKafkaFallbackMethod"
    )

    fun saveFallbackMethod(
        requests: List<*>,
        throwable: Throwable
    ) {
        logCircuitBreakerInfo()
        logger.error {"run notification save fallback method!! ${throwable.message}}"}
    }

    fun getInitFallbackMethod(
        receiverId: Long,
        language: String,
        throwable: Throwable
    ): List<NotificationGetServerResponse> {
        logger.error {
            "run init fall back" +
            "Fallback triggered. Throwable class: ${throwable::class.simpleName}, " +
            "Message: ${throwable.message}, " + "Stacktrace: ${throwable.stackTraceToString()}"
        }

        logCircuitBreakerInfo()
        return listOf()
    }

    fun getScrollFallbackMethod(
        getRequest: NotificationGetRequest,
        language: String,
        throwable: Throwable
    ): List<NotificationGetServerResponse> {
        logger.error { "run scrollFallbackMethod!!\n${throwable.message}}" }
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