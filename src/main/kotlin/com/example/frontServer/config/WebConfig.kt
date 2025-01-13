package com.example.frontServer.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig: WebMvcConfigurer {
    fun createWebClient(baseUrl: String): WebClient {
        return WebClient.builder()
            .baseUrl(baseUrl)
            .defaultHeaders { headers ->
                // can add header!!
                headers.add("Content-Type", "application/json")
            }
            .build()
    }
}