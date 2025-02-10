package com.example.frontServer.dto.logstash

data class BoardEventLog(
    val logEvent: Long,
    val boardId: Long,
    val userId: Long,
)
