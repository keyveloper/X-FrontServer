package com.example.frontServer.exception

import org.springframework.http.HttpStatus

class NotFoundEntityException(
    override val httpStatus: HttpStatus = HttpStatus.NOT_FOUND,
    override val message: String = "This Entity doesn't exist",
    val entityType: Long,
    val id: Long,
): BusinessException(httpStatus, message)