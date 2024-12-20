package com.example.frontServer.controller

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class LangController(
    @Autowired
    private val messageSource: MessageSource
) {
    private val logger = KotlinLogging.logger {}

    @GetMapping("/lang")
    fun getGreeting(@RequestHeader(value = "Accept-Language", defaultValue = "en") language: String)
    : ResponseEntity<String> {
        logger.info { "language: $language" }
        val locale = Locale.forLanguageTag(language)
        logger.info { "locale: $locale" }
        logger.info {"message: ${messageSource.getMessage("greeting", null, locale) }"}

        return ResponseEntity.ok().body(
            messageSource.getMessage("greeting", arrayOf("TOD", "KIM"), locale)
        )
    }
}