package com.example.frontServer.dto.logstash

data class BoardWriteEventLog(
    val logEvent: Long,
    val boardId: Long,
    val userId: Long,
)
