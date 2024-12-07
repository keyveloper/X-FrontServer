package com.example.frontServer.exception

import com.example.frontServer.enum.FrontServerCode

open class CustomErrorException(
    val errorCode: FrontServerCode,
    override val message: String? = null
) : RuntimeException(message)