package com.example.frontServer.exception

class NotFoundEntityException(
    override val message: String
): BusinessException(message)