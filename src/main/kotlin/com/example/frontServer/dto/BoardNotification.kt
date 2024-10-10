package com.example.frontServer.dto

import java.time.LocalDateTime

data class BoardNotification(
    val message: String,
    val createAt: LocalDateTime,
    var publisherImg: String? = null,
    var imgContent: String? = null
)
