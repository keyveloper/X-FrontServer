package com.example.frontServer.exception

import com.example.frontServer.enum.FrontServerError

class CanNotFindEntityException(
    message: String? = "Can not find Entity..."
): CustomErrorException(FrontServerError.NOT_FOUND_ENTITY, message = message)