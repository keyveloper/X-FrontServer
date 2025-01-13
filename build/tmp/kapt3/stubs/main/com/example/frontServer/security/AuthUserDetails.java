package com.example.frontServer.security;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0002\u0010\nJ\t\u0010\u000b\u001a\u00020\u0003H\u00c2\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c2\u0003J\t\u0010\r\u001a\u00020\u0005H\u00c2\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00c2\u0003J7\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u00d6\u0003J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\u0006\u0010\u0016\u001a\u00020\u0003J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\b\u0010\u001a\u001a\u00020\u0011H\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\b\u0010\u001c\u001a\u00020\u0011H\u0016J\b\u0010\u001d\u001a\u00020\u0011H\u0016J\t\u0010\u001e\u001a\u00020\u0005H\u00d6\u0001R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/example/frontServer/security/AuthUserDetails;", "Lorg/springframework/security/core/userdetails/UserDetails;", "userId", "", "username", "", "password", "authorities", "", "Lorg/springframework/security/core/GrantedAuthority;", "(JLjava/lang/String;Ljava/lang/String;Ljava/util/Collection;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "getAuthorities", "getPassword", "getUserId", "getUsername", "hashCode", "", "isAccountNonExpired", "isAccountNonLocked", "isCredentialsNonExpired", "isEnabled", "toString", "frontServer"})
public final class AuthUserDetails implements org.springframework.security.core.userdetails.UserDetails {
    private final long userId = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String username = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String password = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Collection<org.springframework.security.core.GrantedAuthority> authorities = null;
    
    public AuthUserDetails(long userId, @org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    java.util.Collection<? extends org.springframework.security.core.GrantedAuthority> authorities) {
        super();
    }
    
    public final long getUserId() {
        return 0L;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getUsername() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getPassword() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.Collection<org.springframework.security.core.GrantedAuthority> getAuthorities() {
        return null;
    }
    
    @java.lang.Override()
    public boolean isAccountNonExpired() {
        return false;
    }
    
    @java.lang.Override()
    public boolean isAccountNonLocked() {
        return false;
    }
    
    @java.lang.Override()
    public boolean isCredentialsNonExpired() {
        return false;
    }
    
    @java.lang.Override()
    public boolean isEnabled() {
        return false;
    }
    
    private final long component1() {
        return 0L;
    }
    
    private final java.lang.String component2() {
        return null;
    }
    
    private final java.lang.String component3() {
        return null;
    }
    
    private final java.util.Collection<org.springframework.security.core.GrantedAuthority> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.frontServer.security.AuthUserDetails copy(long userId, @org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    java.util.Collection<? extends org.springframework.security.core.GrantedAuthority> authorities) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}