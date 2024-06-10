package com.example.frontServer.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "msa.api")
class MsaApiProperties {
    lateinit var notificationUrl: String
    lateinit var likeUrl: String
    lateinit var timelineUrl: String
}