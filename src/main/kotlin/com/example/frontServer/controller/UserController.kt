package com.example.frontServer.controller

import com.example.frontServer.dto.user.response.UserProfileGetResponse
import com.example.frontServer.dto.auth.SignUpRequest
import com.example.frontServer.dto.user.request.UserProfileGetRequest
import com.example.frontServer.service.user.UserService
import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class UserController(
    private val userService: UserService
) {
    private val logger = KotlinLogging.logger {}

    @PostMapping("/sign-up")
    fun signUp(
        @Valid @RequestBody signUpRequest: SignUpRequest
    ): ResponseEntity<Void> { // sign up 처리 다시
        userService.signUp(signUpRequest)
        return ResponseEntity.ok().build()
    }

    @GetMapping("/getUserProfile")
    fun findUserProfile(
        @Valid @RequestBody request: UserProfileGetRequest
    ): ResponseEntity<UserProfileGetResponse> {
        val result = userService.findMainUserProfile(request)
        return ResponseEntity.ok().body(
            UserProfileGetResponse.of(result)
        )
    }
}