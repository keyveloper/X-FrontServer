package com.example.frontServer.exception

class FallbackFailureException(message: String) : RuntimeException(message){
    fun main() {
        throw FallbackFailureException("Fallback method executed!!")
    }
}