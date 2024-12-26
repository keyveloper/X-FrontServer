package com.example.frontServer.exception

open class BusinessException(
    override val message: String
): RuntimeException(message)