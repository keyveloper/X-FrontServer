package com.example.frontServer.dto

data class BoardNotificationInfo(
    val publisher: Long,
    val publisherImg: String? = null,
    val text: String,
    val contentImg: String? = null,
    val receivers: List<Long>
)
