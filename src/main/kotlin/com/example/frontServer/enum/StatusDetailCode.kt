package com.example.frontServer.enum

enum class StatusDetailCode(val code: Long, val message: String) {
    SUCCESS(0, "api works successfully"),
    FAILED(1, "api doesn't work"),
}