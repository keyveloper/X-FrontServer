package com.example.frontServer.controller

import com.example.frontServer.dto.notification.NotificationGetRequest
import com.example.frontServer.dto.notification.NotificationGetResponse
import com.example.frontServer.service.NotificationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class NotificationController(
    private val notificationService: NotificationService
) {
    @GetMapping("/notification/init")
    fun findInitAll(
        @RequestBody receiverId: Long
    ): ResponseEntity<List<NotificationGetResponse>> {

    }

    @GetMapping("/notification/prev")
    fun findPrevAll(
        @RequestBody request: NotificationGetRequest
    ): ResponseEntity<List<NotificationGetResponse>> {

    }

    @GetMapping("/notification/next")
    fun findNextAll(
        @RequestBody request: NotificationGetRequest
    ): ResponseEntity<List<NotificationGetResponse>> {

    }
}