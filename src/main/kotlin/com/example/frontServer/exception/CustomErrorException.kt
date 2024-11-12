package com.example.frontServer.exception

import com.example.frontServer.enum.FrontServerError

open class CustomErrorException(
    val errorCode: FrontServerError,
    override val message: String? = null
) : RuntimeException(message)