package com.example.frontServer.exception

class FileNotExistException(message : String) : Exception(message) {
    fun main() {
        throw FileNotExistException("stored file not exist")
    }
}