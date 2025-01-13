package com.example.frontServer.exception

import org.springframework.http.HttpStatus

open class BusinessException(
    open val httpStatus: HttpStatus,
    override val message: String
): RuntimeException(message)