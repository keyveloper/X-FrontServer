package com.example.frontServer.enum

enum class LogEvent(val code: Long) {
    BOARD_WRITE(0),
    BOARD_GET(1),
    TEST_LOG(-99)
}