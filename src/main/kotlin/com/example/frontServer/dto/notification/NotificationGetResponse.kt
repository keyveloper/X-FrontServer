package com.example.frontServer.dto.notification

import com.example.frontServer.dto.error.FrontServerErrorResponse
import com.example.frontServer.enum.FrontServerCode

data class NotificationGetResponse(
    // response to client from front
    val notificationGetResult: List<NotificationGetResult>,
    override val responseCode: FrontServerCode
): FrontServerErrorResponse(responseCode)