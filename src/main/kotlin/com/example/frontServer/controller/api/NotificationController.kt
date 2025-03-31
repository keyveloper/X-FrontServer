package com.example.frontServer.controller.api

import com.example.frontServer.dto.notification.request.NotificationGetInitRequest
import com.example.frontServer.dto.notification.request.NotificationGetRequest
import com.example.frontServer.dto.notification.response.NotificationGetResponse
import com.example.frontServer.service.noti.NotificationApiService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class NotificationController(
    private val notificationService: NotificationApiService
) {

    @GetMapping("/test/kubernetes")
    fun kubernetes(): ResponseEntity<String> {
        return ResponseEntity.ok().body(
            notificationService.kubernetes()
        )
    }
    @PostMapping("/getNotification/init")
    fun findInitAll(
        @Valid @RequestBody request: NotificationGetInitRequest,
        @RequestHeader(value = "Accept-Language", defaultValue = "en") language: String
    ): ResponseEntity<NotificationGetResponse> {
        val results = notificationService.fetchInitAll(request.receiverId, language)
        return ResponseEntity.ok().body(
            NotificationGetResponse.of(
                results = results
            )
        )
    }

    @PostMapping("/getNotification/prev")
    fun findPrevAll(
        @RequestBody request: NotificationGetRequest,
        @RequestHeader(value = "Accept-Language", defaultValue = "en") language: String
    ): ResponseEntity<NotificationGetResponse> {
        return ResponseEntity.ok().body(
            NotificationGetResponse.of(
                notificationService.fetchPrevAll(request, language),
            )
        )
    }

    @PostMapping("/getNotification/next")
    fun findNextAll(
        @RequestBody request: NotificationGetRequest,
        @RequestHeader(value = "Accept-Language", defaultValue = "en") language: String
    ): ResponseEntity<NotificationGetResponse> {
        val results = notificationService.fetchNextAll(request, language)
        return ResponseEntity.ok().body(
            NotificationGetResponse.of(
                results = results,
            )
        )
    }
}