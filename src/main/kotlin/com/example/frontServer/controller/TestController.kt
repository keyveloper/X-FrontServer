package com.example.frontServer.controller

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {
    private val logger = KotlinLogging.logger {}
    @GetMapping("/loafBalancing")
    fun loadBalancing() {
        logger.info {"Load Balancing !!!"}
    }
}