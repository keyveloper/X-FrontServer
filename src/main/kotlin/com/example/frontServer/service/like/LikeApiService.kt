package com.example.frontServer.service.like

import com.example.frontServer.config.WebConfig
import com.example.frontServer.dto.like.request.LikeChangeRequest
import com.example.frontServer.dto.like.request.LikeCountGetRequest
import com.example.frontServer.dto.like.request.LikeSaveRequest
import com.example.frontServer.dto.like.response.*
import com.example.frontServer.dto.notification.request.NotificationSaveRequest
import com.example.frontServer.enum.EntityType
import com.example.frontServer.enum.MSAServerErrorCode
import com.example.frontServer.enum.NotificationType
import com.example.frontServer.exception.NotFoundEntityException
import com.example.frontServer.repository.board.BoardRepository
import com.example.frontServer.service.noti.KafkaProducerService
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import io.github.oshai.kotlinlogging.KotlinLogging
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Service
import org.springframework.web.util.UriBuilder

@Service
class LikeApiService(
    private val webConfig: WebConfig,
    private val circuitBreakerRegistry: CircuitBreakerRegistry,
    private val kafkaProducerService: KafkaProducerService,
    private val boardRepository: BoardRepository
) {
    private val circuitBreaker = circuitBreakerRegistry.circuitBreaker("likeApiCircuitBreaker")
    private val logger = KotlinLogging.logger {}
    private val baseUrl = "http://localhost:8082"

    val likeServerWebClient = webConfig.createWebClient(
        baseUrl = baseUrl,
    )

    @CircuitBreaker(
        name = "likeApiCircuitBreaker",
        fallbackMethod = "saveFallback")
    fun saveRequest(likeRequest: LikeSaveRequest): LikeSaveResult { // userId = active user

        val response = likeServerWebClient.post()
            .uri { uriBuilder: UriBuilder ->
                uriBuilder
                    .path("/like")
                    .build()
            }
            .bodyValue(
                LikeSaveRequest(
                    boardId = likeRequest.boardId,
                    userId = likeRequest.userId,
                    likeType = likeRequest.likeType,
                )
            )
            .headers { headers ->
                headers.remove(HttpHeaders.AUTHORIZATION)
            }
            .retrieve()
            .bodyToMono(LikeServerSaveResponse::class.java)
            .block()

        logger.info {"Like save Api response: ${response}"}

        return if (response != null && response.errorCode == MSAServerErrorCode.SUCCESS.code) {
            val targetBoard = boardRepository.findById(likeRequest.boardId).orElseThrow {
                NotFoundEntityException(entityType = EntityType.BOARD.code, id = likeRequest.boardId)
            }
            kafkaProducerService.sendNoti(
                NotificationSaveRequest(
                    publisherId = likeRequest.userId,
                    receiverId = targetBoard.writerId,
                    notificationType = NotificationType.LIKE,
                    targetBoardId = null
                )
            )
            LikeSaveResult.of(response.result)
        } else {
            // is it ok ?
            logger.error {"response is null"}
            LikeSaveResult(null, null)
        }
    }

    @CircuitBreaker(
        name = "likeApiCircuitBreaker",
        fallbackMethod = "likeChangeFallback"
    )
    fun changeRequest(request: LikeChangeRequest): LikeChangeResult {
        val response = likeServerWebClient.post()
            .uri { uriBuilder: UriBuilder ->
                uriBuilder
                    .path("/changeLike")
                    .build()
            }
            .bodyValue(
                request
            )
            .retrieve()
            .bodyToMono(LikeServerChangeResponse::class.java)
            .block()
        logger.info {"like change api response: ${response}"}

        return if (response != null) {
            if (response.errorCode == MSAServerErrorCode.SUCCESS.code) {
                LikeChangeResult.of(response.result)
            } else {
                logger.info {"${response.errorDetails}"}
                LikeChangeResult.of(response.result)
            }
        } else {
            logger.info {"like change api failed: response is null"}
            LikeChangeResult(-1, -1)
        }
    }

    @CircuitBreaker(
        name = "likeApiCircuitBreaker",
        fallbackMethod = "likeCountFallback"
    )
    fun fetchLikeCounts(targetBoardId: Long): Long {
        val response = likeServerWebClient.post()
            .uri { uriBuilder: UriBuilder ->
                uriBuilder
                    .path("/countLikes")
                    .build()
            }
            .bodyValue(
                LikeCountGetRequest(targetBoardId)
            )
            .retrieve()
            .bodyToMono(LikeServerCountResponse::class.java)
            .block()
        logger.info {"like count api response: ${response}"}

        return if (response != null) {
            if (response.errorCode == MSAServerErrorCode.SUCCESS.code) {
                response.result.totalCount
            } else {
                logger.error {"like count api error: unexpected response"}
                0L
            }
        } else {
            logger.error {"like count api failed: response failed!!"}
            0L
        }
    }

    // save 메서드의 fallbackMethod
    fun saveFallback(boardId: Long, userId: Long, throwable: Throwable): Long {
        logger.error { "run save fallback ${throwable.message}" }
        logCircuitBreakerInfo()
        return 0L
    }

    fun changeFallback(request: LikeChangeRequest, throwable: Throwable): LikeChangeResult {
        logger.error {"run change fallback: ${throwable.message}"}
        logCircuitBreakerInfo()
        return LikeChangeResult(-1, -1)
    }

    fun likeCountFallback(targetBoardId: Long, throwable: Throwable): Long {
        logger.error { "run count Fallback ${throwable.message}"}
        logCircuitBreakerInfo()
        return 0L
    }

    private fun logCircuitBreakerInfo() {
        val metrics = circuitBreaker.metrics

        logger.info { "CircuitBreaker state: ${circuitBreaker.state}" }
        logger.info { "Number of successful calls: ${metrics.numberOfSuccessfulCalls}" }
        logger.info { "Number of failed calls: ${metrics.numberOfFailedCalls}" }
        logger.info { "Failure rate: ${metrics.failureRate}%" }
    }
}