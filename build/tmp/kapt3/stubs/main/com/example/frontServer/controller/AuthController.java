package com.example.frontServer.controller;

@org.springframework.web.bind.annotation.RestController()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0017J\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b2\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/frontServer/controller/AuthController;", "", "authService", "Lcom/example/frontServer/service/user/AuthService;", "(Lcom/example/frontServer/service/user/AuthService;)V", "logger", "Lio/github/oshai/kotlinlogging/KLogger;", "login", "Lorg/springframework/http/ResponseEntity;", "Lcom/example/frontServer/dto/auth/LoginResponse;", "loginInRequest", "Lcom/example/frontServer/dto/auth/LoginRequest;", "validToken", "Lcom/example/frontServer/dto/auth/TokenValidationResponse;", "user", "Lcom/example/frontServer/security/AuthUserDetails;", "frontServer"})
public class AuthController {
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.service.user.AuthService authService = null;
    @org.jetbrains.annotations.NotNull()
    private final io.github.oshai.kotlinlogging.KLogger logger = null;
    
    public AuthController(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.service.user.AuthService authService) {
        super();
    }
    
    @org.springframework.web.bind.annotation.PostMapping(value = {"/login"})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<com.example.frontServer.dto.auth.LoginResponse> login(@jakarta.validation.Valid()
    @org.springframework.web.bind.annotation.RequestBody()
    @org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.auth.LoginRequest loginInRequest) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.PostMapping(value = {"/valid/token"})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<com.example.frontServer.dto.auth.TokenValidationResponse> validToken(@org.springframework.security.core.annotation.AuthenticationPrincipal()
    @org.jetbrains.annotations.NotNull()
    com.example.frontServer.security.AuthUserDetails user) {
        return null;
    }
}