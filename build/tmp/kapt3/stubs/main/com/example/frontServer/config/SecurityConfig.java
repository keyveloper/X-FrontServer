package com.example.frontServer.config;

@org.springframework.context.annotation.Configuration()
@org.springframework.security.config.annotation.web.configuration.EnableWebSecurity()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0017J\b\u0010\r\u001a\u00020\u000eH\u0017J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/frontServer/config/SecurityConfig;", "", "jwtAuthenticationEntryPoint", "Lcom/example/frontServer/security/JwtAuthenticationEntryPoint;", "jwtAuthenticationProvider", "Lcom/example/frontServer/security/JwtAuthenticationProvider;", "userDetailsService", "Lorg/springframework/security/core/userdetails/UserDetailsService;", "(Lcom/example/frontServer/security/JwtAuthenticationEntryPoint;Lcom/example/frontServer/security/JwtAuthenticationProvider;Lorg/springframework/security/core/userdetails/UserDetailsService;)V", "authenticationManager", "Lorg/springframework/security/authentication/AuthenticationManager;", "http", "Lorg/springframework/security/config/annotation/web/builders/HttpSecurity;", "passwordEncoder", "Lorg/springframework/security/crypto/password/PasswordEncoder;", "securityFilterChain", "Lorg/springframework/security/web/SecurityFilterChain;", "frontServer"})
public class SecurityConfig {
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.security.JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.security.JwtAuthenticationProvider jwtAuthenticationProvider = null;
    @org.jetbrains.annotations.NotNull()
    private final org.springframework.security.core.userdetails.UserDetailsService userDetailsService = null;
    
    public SecurityConfig(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.security.JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint, @org.jetbrains.annotations.NotNull()
    com.example.frontServer.security.JwtAuthenticationProvider jwtAuthenticationProvider, @org.jetbrains.annotations.NotNull()
    org.springframework.security.core.userdetails.UserDetailsService userDetailsService) {
        super();
    }
    
    @org.springframework.context.annotation.Bean()
    @org.jetbrains.annotations.NotNull()
    public org.springframework.security.web.SecurityFilterChain securityFilterChain(@org.jetbrains.annotations.NotNull()
    org.springframework.security.config.annotation.web.builders.HttpSecurity http) {
        return null;
    }
    
    @org.springframework.context.annotation.Bean()
    @org.jetbrains.annotations.NotNull()
    public org.springframework.security.crypto.password.PasswordEncoder passwordEncoder() {
        return null;
    }
    
    @org.springframework.context.annotation.Bean()
    @org.jetbrains.annotations.NotNull()
    public org.springframework.security.authentication.AuthenticationManager authenticationManager(@org.jetbrains.annotations.NotNull()
    org.springframework.security.config.annotation.web.builders.HttpSecurity http) {
        return null;
    }
}