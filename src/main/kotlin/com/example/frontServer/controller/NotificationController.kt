package com.example.frontServer.controller

import com.example.frontServer.dto.notification.NotificationGetRequest
import com.example.frontServer.dto.notification.NotificationGetResponse
import com.example.frontServer.enum.FrontServerCode
import com.example.frontServer.service.NotificationService
import org.intellij.lang.annotations.Language
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class NotificationController(
    private val notificationService: NotificationService
) {
    @PostMapping("/notification/init")
    fun findInitAll(
        @RequestBody receiverId: Long,
        @RequestHeader(value = "Accept-Language", defaultValue = "en") language: String
    ): ResponseEntity<NotificationGetResponse> {
        return ResponseEntity.ok().body(
            NotificationGetResponse.of(
                notificationService.fetchInitAll(receiverId, language),
                FrontServerCode.SUCCESS
            )
        )
    }

    @PostMapping("/notification/prev")
    fun findPrevAll(
        @RequestBody request: NotificationGetRequest,
        @RequestHeader(value = "Accept-Language", defaultValue = "en") language: String
    ): ResponseEntity<NotificationGetResponse> {
        return ResponseEntity.ok().body(
            NotificationGetResponse.of(
                notificationService.fetchPrevAll(request, language),
                FrontServerCode.SUCCESS
            )
        )
    }

    @PostMapping("/notification/next")
    fun findNextAll(
        @RequestBody request: NotificationGetRequest,
        @RequestHeader(value = "Accept-Language", defaultValue = "en") language: String
    ): ResponseEntity<NotificationGetResponse> {
        return ResponseEntity.ok().body(
            NotificationGetResponse.of(
                notificationService.fetchNextAll(request, language),
                FrontServerCode.SUCCESS
            )
        )
    }
}