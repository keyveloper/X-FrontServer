package com.example.frontServer.controller

import com.example.frontServer.service.noti.NotificationApiService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController(
    private val notificationApiService: NotificationApiService
) {

    @GetMapping("/test")
    fun test(): String {
        return "hello linux!"
    }

    @PostMapping("/test/kafka")
    fun testKafkaPublish(@RequestBody message: String) {
        notificationApiService.testKafkaPublish(message)
    }
}