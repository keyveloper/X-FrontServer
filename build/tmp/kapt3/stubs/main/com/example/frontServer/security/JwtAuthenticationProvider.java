package com.example.frontServer.security;

@org.springframework.stereotype.Component()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0017\u0018\u00002\u00020\u0001B!\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/frontServer/security/JwtAuthenticationProvider;", "", "jwtSecret", "", "jwtExpirationMs", "", "userDetailsService", "Lcom/example/frontServer/service/user/UserDetailsServiceImpl;", "(Ljava/lang/String;JLcom/example/frontServer/service/user/UserDetailsServiceImpl;)V", "logger", "Lio/github/oshai/kotlinlogging/KLogger;", "secretKey", "Ljavax/crypto/SecretKey;", "generateToken", "authentication", "Lorg/springframework/security/core/Authentication;", "getUserFromToken", "Lorg/springframework/security/core/userdetails/UserDetails;", "token", "validateToken", "", "frontServer"})
public class JwtAuthenticationProvider {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String jwtSecret = null;
    private final long jwtExpirationMs = 0L;
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.service.user.UserDetailsServiceImpl userDetailsService = null;
    @org.jetbrains.annotations.NotNull()
    private final javax.crypto.SecretKey secretKey = null;
    @org.jetbrains.annotations.NotNull()
    private final io.github.oshai.kotlinlogging.KLogger logger = null;
    
    public JwtAuthenticationProvider(@org.springframework.beans.factory.annotation.Value(value = "${jwt.secret}")
    @org.jetbrains.annotations.NotNull()
    java.lang.String jwtSecret, @org.springframework.beans.factory.annotation.Value(value = "${jwt.expiration}")
    long jwtExpirationMs, @org.jetbrains.annotations.NotNull()
    com.example.frontServer.service.user.UserDetailsServiceImpl userDetailsService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String generateToken(@org.jetbrains.annotations.NotNull()
    org.springframework.security.core.Authentication authentication) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public org.springframework.security.core.userdetails.UserDetails getUserFromToken(@org.jetbrains.annotations.NotNull()
    java.lang.String token) {
        return null;
    }
    
    public boolean validateToken(@org.jetbrains.annotations.NotNull()
    java.lang.String token) {
        return false;
    }
}