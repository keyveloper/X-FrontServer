package com.example.frontServer.exception

import com.example.frontServer.enum.FrontServerError

class InValidIdException(
    message: String? = "Invalid Id"
): CustomErrorException(FrontServerError.INVALID_ID, message)