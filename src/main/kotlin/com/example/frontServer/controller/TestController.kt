package com.example.frontServer.controller

import com.example.frontServer.dto.logstash.BoardEventLog
import com.example.frontServer.enum.LogEvent
import io.github.oshai.kotlinlogging.KotlinLogging
import net.logstash.logback.argument.StructuredArguments
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {
    private val logger = KotlinLogging.logger {}
    private val logstashLogger = LoggerFactory.getLogger("com.example.logstash")
    @GetMapping("/loafBalancing")
    fun loadBalancing() {
        logger.info {"Load Balancing !!!"}
    }

    @GetMapping("/jenkins")
    fun jenkins(): ResponseEntity<String> {
        return ResponseEntity.ok().body("Hello Jenkins build!")
    }

    @GetMapping("/test/alert")
    fun alert() {
        val event = BoardEventLog(
            logEvent = LogEvent.TEST_LOG,
            boardId = -99L,
            userId = -99L
        )
        logstashLogger.error(
            "alerting test ... ",
            StructuredArguments.keyValue("boardEvent", event)
        )

    }
}