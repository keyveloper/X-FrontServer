package com.example.frontServer.service.noti

import com.example.frontServer.config.MsaApiProperties
import com.example.frontServer.config.WebConfig
import io.github.oshai.kotlinlogging.KotlinLogging
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.springframework.stereotype.Service
import org.springframework.web.util.UriBuilder

@Service
class NotificationApiTestService( // open 인 이유는 kotlin-spring 플러그인 때문
    private val webConfig: WebConfig,
    private val circuitBreakerRegistry: CircuitBreakerRegistry,
    private val msaApiProperties: MsaApiProperties,
) {
    private val circuitBreaker = circuitBreakerRegistry.circuitBreaker("notiApiServerCircuitBreaker")
    private val looger = KotlinLogging.logger {}

    @CircuitBreaker(
        name = "notiApiServerCircuitBreaker",
        fallbackMethod = "testRequestFallback"
    )
    fun testRequest(): String {
        val notiWebClient = webConfig.createWebClient(msaApiProperties.notificationUrl)

        val response = notiWebClient.get()
            .uri { uriBuilder: UriBuilder ->
                uriBuilder
                    .path("/test/frontServer-connection")
                    .build()
            }
            .retrieve()
            .bodyToMono(String::class.java)
            .block()

        return response ?: "empty response"
    }


    fun testRequestFallback(throwable: Throwable): String {
        return "notification server is not working!"
    }
}