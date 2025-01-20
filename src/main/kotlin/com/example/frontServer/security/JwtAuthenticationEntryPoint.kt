package com.example.frontServer.security

import com.example.frontServer.dto.auth.TokenValidationResponse
import com.example.frontServer.enum.StatusDetailCode
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component
import org.springframework.security.core.AuthenticationException

// for JWT Token error
@Component
class JwtAuthenticationEntryPoint : AuthenticationEntryPoint {
    private val objectMapper = jacksonObjectMapper().apply {
        registerKotlinModule()
    }

    override fun commence(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        authException: AuthenticationException?
    ) {
        if (response != null) {
            response.status = HttpServletResponse.SC_UNAUTHORIZED // 401 Unauthorized
            response.contentType = "application/json;charset=UTF-8"

            // DTO 객체 생성
            val tokenValidationResponse = TokenValidationResponse(
                id = null, // 오류 상황에는 id가 없을 수도 있음
                statusDetailsCode = StatusDetailCode.FAILED, // 예시로 사용한 코드, 실제 코드로 대체
                message = "Invalid or expired JWT token."
            )

            // DTO를 JSON 문자열로 직렬화
            val jsonResponse = objectMapper.writeValueAsString(/* value = */ tokenValidationResponse)

            response.writer.write(jsonResponse)
        }
    }
}