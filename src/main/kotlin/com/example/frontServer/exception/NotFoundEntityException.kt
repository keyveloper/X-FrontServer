package com.example.frontServer.exception

class NotFoundEntityException(message: String): RuntimeException(message) {
    fun main() {
        throw NotFoundEntityException("Can't find entity")
    }
}