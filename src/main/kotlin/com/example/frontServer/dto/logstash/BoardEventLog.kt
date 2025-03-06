package com.example.frontServer.dto.logstash

import com.example.frontServer.enum.LogEvent

data class BoardEventLog(
    val logEvent: LogEvent,
    val boardId: Long,
    val userId: Long,
)
