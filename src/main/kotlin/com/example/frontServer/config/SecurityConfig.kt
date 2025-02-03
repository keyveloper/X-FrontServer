package com.example.frontServer.config

import com.example.frontServer.security.JwtAuthenticationEntryPoint
import com.example.frontServer.security.JwtAuthenticationFilter
import com.example.frontServer.security.JwtAuthenticationProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwtAuthenticationEntryPoint: JwtAuthenticationEntryPoint,
    private val jwtAuthenticationProvider: JwtAuthenticationProvider,
    private val userDetailsService: UserDetailsService
){

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.csrf { csrf -> csrf.disable() }
            .authorizeHttpRequests { auth ->
                auth
                    .requestMatchers("/login").permitAll()
                    .requestMatchers("/sign-up").permitAll()
                    .requestMatchers("/boards").permitAll()
                    .requestMatchers("/board/timeline/next").permitAll()
                    .requestMatchers("/lang").permitAll()
                    .requestMatchers("/noti/lang").permitAll()
                    .requestMatchers("/test").permitAll()
                    .requestMatchers("/test/kafka").permitAll()
                    .requestMatchers("/saveLog").permitAll()
                    .anyRequest().authenticated()
            }.exceptionHandling {
                it.authenticationEntryPoint(jwtAuthenticationEntryPoint) // 인증 실패 처리
            }
            .addFilterBefore(JwtAuthenticationFilter(jwtAuthenticationProvider),
                UsernamePasswordAuthenticationFilter::class.java,)
        return http.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()//
    }


    @Bean
    fun authenticationManager(http: HttpSecurity): AuthenticationManager {
        val authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder::class.java)
        authenticationManagerBuilder
            .userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder())
        return authenticationManagerBuilder.build()
    }
}