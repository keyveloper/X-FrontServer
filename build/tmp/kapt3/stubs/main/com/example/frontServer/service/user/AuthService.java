package com.example.frontServer.service.user;

@org.springframework.stereotype.Service()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/example/frontServer/service/user/AuthService;", "", "jwtTokenProvider", "Lcom/example/frontServer/security/JwtAuthenticationProvider;", "authenticationManger", "Lorg/springframework/security/authentication/AuthenticationManager;", "(Lcom/example/frontServer/security/JwtAuthenticationProvider;Lorg/springframework/security/authentication/AuthenticationManager;)V", "logger", "Lio/github/oshai/kotlinlogging/KLogger;", "login", "Lcom/example/frontServer/dto/auth/LoginResult;", "loginRequest", "Lcom/example/frontServer/dto/auth/LoginRequest;", "frontServer"})
public class AuthService {
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.security.JwtAuthenticationProvider jwtTokenProvider = null;
    @org.jetbrains.annotations.NotNull()
    private final org.springframework.security.authentication.AuthenticationManager authenticationManger = null;
    @org.jetbrains.annotations.NotNull()
    private final io.github.oshai.kotlinlogging.KLogger logger = null;
    
    public AuthService(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.security.JwtAuthenticationProvider jwtTokenProvider, @org.jetbrains.annotations.NotNull()
    org.springframework.security.authentication.AuthenticationManager authenticationManger) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.example.frontServer.dto.auth.LoginResult login(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.auth.LoginRequest loginRequest) {
        return null;
    }
}