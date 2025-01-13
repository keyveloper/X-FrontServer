package com.example.frontServer.security;

@org.springframework.stereotype.Component()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\t\u001a\u00020\nH\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/frontServer/security/JwtAuthenticationFilter;", "Lorg/springframework/web/filter/OncePerRequestFilter;", "jwtAuthenticationProvider", "Lcom/example/frontServer/security/JwtAuthenticationProvider;", "(Lcom/example/frontServer/security/JwtAuthenticationProvider;)V", "logger", "Lio/github/oshai/kotlinlogging/KLogger;", "doFilterInternal", "", "request", "Ljakarta/servlet/http/HttpServletRequest;", "response", "Ljakarta/servlet/http/HttpServletResponse;", "filterChain", "Ljakarta/servlet/FilterChain;", "getTokenFromRequest", "", "frontServer"})
public class JwtAuthenticationFilter extends org.springframework.web.filter.OncePerRequestFilter {
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.security.JwtAuthenticationProvider jwtAuthenticationProvider = null;
    @org.jetbrains.annotations.NotNull()
    private final io.github.oshai.kotlinlogging.KLogger logger = null;
    
    public JwtAuthenticationFilter(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.security.JwtAuthenticationProvider jwtAuthenticationProvider) {
        super();
    }
    
    @java.lang.Override()
    protected void doFilterInternal(@org.jetbrains.annotations.NotNull()
    jakarta.servlet.http.HttpServletRequest request, @org.jetbrains.annotations.NotNull()
    jakarta.servlet.http.HttpServletResponse response, @org.jetbrains.annotations.NotNull()
    jakarta.servlet.FilterChain filterChain) {
    }
    
    private java.lang.String getTokenFromRequest(jakarta.servlet.http.HttpServletRequest request) {
        return null;
    }
}