package com.example.frontServer.controller

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {
    private val logger = KotlinLogging.logger {}
    @GetMapping("/loafBalancing")
    fun loadBalancing() {
        logger.info {"Load Balancing !!!"}
    }

    @GetMapping("/jenkins")
    fun jenkins(): ResponseEntity<String> {
        return ResponseEntity.ok().body("Hello Jenkins build!")
    }
}