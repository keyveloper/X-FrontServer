package com.example.frontServer.exception

class EntitySaveFailure(message: String): RuntimeException(message){
    fun main() {
        throw EntitySaveFailure("Entity save failure")
    }
}