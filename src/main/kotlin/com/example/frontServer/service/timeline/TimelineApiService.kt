package com.example.frontServer.service.timeline

import com.example.frontServer.config.WebConfig
import com.example.frontServer.dto.timeline.request.TimelineGetRequest
import com.example.frontServer.dto.timeline.request.TimelineSaveRequest
import com.example.frontServer.dto.timeline.response.TimelineServerGetResponse
import com.example.frontServer.dto.timeline.response.TimelineServerSaveResponse
import com.example.frontServer.enum.MSAServerErrorCode
import io.github.oshai.kotlinlogging.KotlinLogging
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.springframework.stereotype.Service
import org.springframework.web.util.UriBuilder

@Service
class TimelineApiService( // board-timeline rep or api connection
    private val webConfig: WebConfig,
    private val circuitBreakerRegistry: CircuitBreakerRegistry,
) {
    private val circuitBreaker = circuitBreakerRegistry.circuitBreaker("timelineApiCircuitBreaker")
    private val logger = KotlinLogging.logger {}
    private val baseUrl = "http://localhost:8083"
    val timelineWebClient = webConfig.createWebClient(baseUrl)

    // save timeline
    @CircuitBreaker(
        name = "timelineApiCircuitBreaker",
        fallbackMethod = "saveFallbackMethod"
    )
    fun saveRequest(requests: List<TimelineSaveRequest>){
        val response = timelineWebClient.post()
            .uri { uriBuilder: UriBuilder ->
                uriBuilder
                    .path("/saveTimeline")
                    .build()
            }
            .bodyValue(
                requests
            )
            .retrieve()
            .bodyToMono(TimelineServerSaveResponse::class.java)
            .block()

        if (response != null && response.errorCode != MSAServerErrorCode.SUCCESS) {
            // 실패시에 구체적인 내용을 확인한다.
            logger.info {
                "errorDetails: ${response.errorDetails}" +
                        "errorCode: ${response.errorCode}"
            }
        } else {
            // 성공시에 SUCCESS 코드만 확인 되도록
            logger.info {
                "errorCode: ${response?.errorCode}"
            }
        }
    }

    @CircuitBreaker(
        name = "timelineApiCircuitBreaker",
        fallbackMethod = "getFallbackMethod"
    )
    fun requestTimelineInitBoardIds(request: TimelineGetRequest): List<Long> {
        val response = timelineWebClient.post()
            .uri { uriBuilder: UriBuilder ->
                uriBuilder
                    .path("/getTimeline/init")
                    .build()
            }
            .bodyValue(request)
            .retrieve()
            .bodyToMono(TimelineServerGetResponse::class.java)
            .block()

        return response?.let {
            response.result.map { it.boardId }
        } ?: listOf()
    }

    @CircuitBreaker(
        name = "timelineApiCircuitBreaker",
        fallbackMethod = "getFallbackMethod"
    )
    fun requestTimelineNextBoardIds(request: TimelineGetRequest): List<Long> {
        val response = timelineWebClient.post()
            .uri { uriBuilder: UriBuilder ->
                uriBuilder
                    .path("/getTimeline/next")
                    .build()
            }
            .bodyValue(request)
            .retrieve()
            .bodyToMono(TimelineServerGetResponse::class.java)
            .block()

        return response?.let {
            response.result.map { it.boardId }
        } ?: listOf()
    }

    @CircuitBreaker(
        name = "timelineApiCircuitBreaker",
        fallbackMethod = "getFallbackMethod"
    )
    fun requestTimelinePrevBoardIds(request: TimelineGetRequest): List<Long> {
        val response = timelineWebClient.post()
            .uri { uriBuilder: UriBuilder ->
                uriBuilder
                    .path("/getTimeline/prev")
                    .build()
            }
            .bodyValue(request)
            .retrieve()
            .bodyToMono(TimelineServerGetResponse::class.java)
            .block()

        return response?.let {
            response.result.map { it.boardId }
        } ?: listOf()
    }

    fun saveFallbackMethod(request: List<TimelineSaveRequest>) {
        logger.error { "timeline api is not working..." }
    }

    fun getFallbackMethod(request: TimelineGetRequest): List<Long> {
        return listOf()
    }
}