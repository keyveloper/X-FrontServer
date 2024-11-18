package com.example.frontServer.controller

import com.example.frontServer.dto.user.UserResponse
import com.example.frontServer.dto.auth.SignUpRequest
import com.example.frontServer.dto.auth.SignUpResponse
import com.example.frontServer.service.UserService
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
    ): ResponseEntity<SignUpResponse> {
        userService.signUp(signUpRequest)
        return ResponseEntity.ok().body(
            SignUpResponse(
                errorResponse = null
            )
        )
    }

    @GetMapping("/user")
    fun findUserByUsername(
        @RequestParam username: String
    ): ResponseEntity<UserResponse> {
        return ResponseEntity.ok().body(
            UserResponse.of(userService.findByuUsername(username)!!)
            // service에서 null 처리를 수행함
        )
    }//
}