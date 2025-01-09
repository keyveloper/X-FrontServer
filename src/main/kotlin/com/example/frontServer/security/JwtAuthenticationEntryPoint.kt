package com.example.frontServer.security

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component
import org.springframework.security.core.AuthenticationException

@Component
class JwtAuthenticationEntryPoint : AuthenticationEntryPoint {
    override fun commence(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        authException: AuthenticationException?
    ) {
        response?.status = HttpServletResponse.SC_UNAUTHORIZED // 401 Unauthorized
        response?.contentType = "application/json"
        response?.writer?.write(
            """{"error": "Invalid or expired JWT token."}"""
        )
    }
}