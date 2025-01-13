package com.example.frontServer.service.user;

@org.springframework.stereotype.Service()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/frontServer/service/user/UserDetailsServiceImpl;", "Lorg/springframework/security/core/userdetails/UserDetailsService;", "userRepository", "Lcom/example/frontServer/repository/user/UserRepository;", "userRoleRepository", "Lcom/example/frontServer/repository/user/UserRoleRepository;", "(Lcom/example/frontServer/repository/user/UserRepository;Lcom/example/frontServer/repository/user/UserRoleRepository;)V", "loadUserByUsername", "Lorg/springframework/security/core/userdetails/UserDetails;", "username", "", "frontServer"})
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.repository.user.UserRepository userRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.repository.user.UserRoleRepository userRoleRepository = null;
    
    public UserDetailsServiceImpl(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.repository.user.UserRepository userRepository, @org.jetbrains.annotations.NotNull()
    com.example.frontServer.repository.user.UserRoleRepository userRoleRepository) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(@org.jetbrains.annotations.NotNull()
    java.lang.String username) {
        return null;
    }
}