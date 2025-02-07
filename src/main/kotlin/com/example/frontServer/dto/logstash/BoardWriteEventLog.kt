package com.example.frontServer.dto.logstash

data class BoardWriteEventLog(
    val logEvent: Int,
    val boardId: Long,
    val userId: Long,
)
