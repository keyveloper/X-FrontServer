package com.example.frontServer.controller

import com.example.frontServer.dto.auth.LoginRequest
import com.example.frontServer.dto.auth.LoginResponse
import com.example.frontServer.dto.auth.TokenValidationResponse
import com.example.frontServer.enum.StatusDetailCode
import com.example.frontServer.security.AuthUserDetails
import com.example.frontServer.service.user.AuthService
import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController(
    private val authService: AuthService,
) {
    private val logger = KotlinLogging.logger {}
    @PostMapping("/login")
    fun login(
        @Valid @RequestBody loginInRequest: LoginRequest
    ): ResponseEntity<LoginResponse> {
        return ResponseEntity.ok().body(
            LoginResponse.of(authService.login(loginInRequest))
        )
    }

    @PostMapping("/valid/token")
    fun validToken(
        @AuthenticationPrincipal user: AuthUserDetails,
    ): ResponseEntity<TokenValidationResponse> {
        return ResponseEntity.ok().body(
                TokenValidationResponse(
                    id = user.getUserId(),
                    statusDetailsCode = StatusDetailCode.SUCCESS,
                    message = null
                )
        )
    }
}