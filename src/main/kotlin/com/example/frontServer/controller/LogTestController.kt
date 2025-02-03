package com.example.frontServer.controller

import io.github.oshai.kotlinlogging.KotlinLogging
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.math.log

@RestController
class LogTestController {
    private val logger = KotlinLogging.logger {}
    private val testSaveLogger = LoggerFactory.getLogger("com.example.frontServer.testFileSaveLogger")
    @PostMapping("/saveLog")
    fun saveLog() {
        logger.info {"save Log!"}
        testSaveLogger.error("{\"key\": \"value\"}")
    }
}