package com.example.frontServer.exception

import com.example.frontServer.dto.auth.TokenValidationResponse
import com.example.frontServer.enum.StatusDetailCode
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.AuthenticationException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(ex: BusinessException): ResponseEntity<String> {
        return ResponseEntity.status(ex.httpStatus).body(
            ex.message
        )
    }

    @ExceptionHandler(AuthenticationException::class)
    fun handleSecurityAuthenticationException(ex: AuthenticationException): ResponseEntity<TokenValidationResponse> {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
            TokenValidationResponse(
                id = null,
                statusDetailsCode = StatusDetailCode.AUTHENTICATION_FAILED.code,
                message = StatusDetailCode.AUTHENTICATION_FAILED.message
            )
        )
    }
}