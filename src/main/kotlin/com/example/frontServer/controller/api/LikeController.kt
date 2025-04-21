package com.example.frontServer.controller.api

import com.example.frontServer.dto.like.request.LikeChangeRequest
import com.example.frontServer.dto.like.request.LikeSaveRequest
import com.example.frontServer.dto.like.response.LikeChangeResponse
import com.example.frontServer.dto.like.response.LikeSaveResponse
import com.example.frontServer.enum.StatusDetailCode
import com.example.frontServer.service.LikeApiService
import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class LikeController(
    private val likeService: LikeApiService
) {
    private val logger = KotlinLogging.logger {}

    @PostMapping("/saveLike")
    fun save(
        @Valid @RequestBody likeRequest: LikeSaveRequest,
    ): ResponseEntity<LikeSaveResponse> {
        val result = likeService.saveRequest(likeRequest)
        return ResponseEntity.ok().body(
            LikeSaveResponse.of(
                result,
                StatusDetailCode.SUCCESS.code,
                message = null
            )
        )
    }

    @PostMapping("/changeLike")
    fun changeType(
        @Valid @RequestBody request: LikeChangeRequest
    ): ResponseEntity<LikeChangeResponse> {
        val result = likeService.changeRequest(request)
        return ResponseEntity.ok().body(
            LikeChangeResponse.of(
                result,
                StatusDetailCode.SUCCESS.code,
                message = "change success"
            )
        )
    }
}