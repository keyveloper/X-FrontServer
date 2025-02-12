package com.example.frontServer.security

import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtAuthenticationFilter(
    private val jwtAuthenticationProvider: JwtAuthenticationProvider
) : OncePerRequestFilter() {
    private val authFilterLogger = KotlinLogging.logger {}
    override fun shouldNotFilter(request: HttpServletRequest): Boolean {
        val path = request.requestURI

        val skip = path.startsWith("/swagger-ui") ||
                path.startsWith("/v3/api-docs") ||
                path.startsWith("/webjars") ||
                path.startsWith("/actuator")
        authFilterLogger.info { "shouldNotFilter() for path: $path, skip filter: $skip" }
        return skip
    }
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain) {
        val token = getTokenFromRequest(request)
        authFilterLogger.info { "JwtAuthenticationFilter executed for request URI: ${request.requestURI}" }
        if (token != null && jwtAuthenticationProvider.validateToken(token)) {
            val userDetails = jwtAuthenticationProvider.getUserFromToken(token)

            val authentication = UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.authorities
            )
            authentication.details = WebAuthenticationDetailsSource().buildDetails(request)
            SecurityContextHolder.getContext().authentication = authentication
        }
        filterChain.doFilter(request, response)
    }


    private fun getTokenFromRequest(request: HttpServletRequest): String? {
        val bearerToken = request.getHeader("Authorization")
        return if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            bearerToken.substring(7)
        } else null
    }


}