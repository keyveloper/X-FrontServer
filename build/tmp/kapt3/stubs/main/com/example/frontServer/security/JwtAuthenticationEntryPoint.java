package com.example.frontServer.security;

@org.springframework.stereotype.Component()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/example/frontServer/security/JwtAuthenticationEntryPoint;", "Lorg/springframework/security/web/AuthenticationEntryPoint;", "()V", "commence", "", "request", "Ljakarta/servlet/http/HttpServletRequest;", "response", "Ljakarta/servlet/http/HttpServletResponse;", "authException", "Lorg/springframework/security/core/AuthenticationException;", "frontServer"})
public class JwtAuthenticationEntryPoint implements org.springframework.security.web.AuthenticationEntryPoint {
    
    public JwtAuthenticationEntryPoint() {
        super();
    }
    
    @java.lang.Override()
    public void commence(@org.jetbrains.annotations.Nullable()
    jakarta.servlet.http.HttpServletRequest request, @org.jetbrains.annotations.Nullable()
    jakarta.servlet.http.HttpServletResponse response, @org.jetbrains.annotations.Nullable()
    org.springframework.security.core.AuthenticationException authException) {
    }
}