package com.example.frontServer.controller.api

import com.example.frontServer.dto.like.request.LikeSaveRequest
import com.example.frontServer.security.AuthUserDetails
import com.example.frontServer.service.like.LikeApiService
import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class LikeController(
    private val likeService: LikeApiService
) {
    private val logger = KotlinLogging.logger {}

    @PostMapping("/like")
    fun save(
        @Valid @RequestBody likeRequest: LikeSaveRequest,
        @AuthenticationPrincipal user: AuthUserDetails
    ): ResponseEntity<String> {
        val result = likeService.saveRequest(likeRequest, user.getUserId())

        return if (result.success) {
            ResponseEntity.ok().body(
                result.message
            )
        } else {
            ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(result.message)
            // 이렇게 보내는거  괜찮??
        }
    }
}