package com.example.frontServer.exception

import org.springframework.http.HttpStatus

class DuplicatedIdException(
    override val httpStatus: HttpStatus,
    override val message: String,
): BusinessException(httpStatus, message)