package com.example.frontServer.exception

class EntityDeleteFailureException(message: String): RuntimeException(message) {
    fun main() {
        throw EntityDeleteFailureException("Entity delete failure")
    }
}