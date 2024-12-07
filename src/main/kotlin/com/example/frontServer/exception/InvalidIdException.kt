package com.example.frontServer.exception

import com.example.frontServer.enum.FrontServerCode

class InvalidIdException(
    message: String? = "Invalid Id"
): CustomErrorException(FrontServerCode.INVALID_ID, message)