package com.example.frontServer.dto.error

import com.example.frontServer.enum.StatusDetailCode

open class FrontStatusDetailResponse(
    open val statusDetailsCode: StatusDetailCode,
    open val message: String?,
)