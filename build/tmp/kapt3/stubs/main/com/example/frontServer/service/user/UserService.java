package com.example.frontServer.service.user;

@org.springframework.stereotype.Service()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0017J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0011H\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/example/frontServer/service/user/UserService;", "", "userRepository", "Lcom/example/frontServer/repository/user/UserRepository;", "userRoleRepository", "Lcom/example/frontServer/repository/user/UserRoleRepository;", "passwordEncoder", "Lorg/springframework/security/crypto/password/PasswordEncoder;", "userFollowService", "Lcom/example/frontServer/service/user/UserFollowService;", "(Lcom/example/frontServer/repository/user/UserRepository;Lcom/example/frontServer/repository/user/UserRoleRepository;Lorg/springframework/security/crypto/password/PasswordEncoder;Lcom/example/frontServer/service/user/UserFollowService;)V", "findMainUserProfile", "Lcom/example/frontServer/dto/user/response/UserProfileGetResult;", "request", "Lcom/example/frontServer/dto/user/request/UserProfileGetRequest;", "signUp", "", "Lcom/example/frontServer/dto/auth/SignUpRequest;", "frontServer"})
public class UserService {
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.repository.user.UserRepository userRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.repository.user.UserRoleRepository userRoleRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final org.springframework.security.crypto.password.PasswordEncoder passwordEncoder = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.service.user.UserFollowService userFollowService = null;
    
    public UserService(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.repository.user.UserRepository userRepository, @org.jetbrains.annotations.NotNull()
    com.example.frontServer.repository.user.UserRoleRepository userRoleRepository, @org.jetbrains.annotations.NotNull()
    org.springframework.security.crypto.password.PasswordEncoder passwordEncoder, @org.jetbrains.annotations.NotNull()
    com.example.frontServer.service.user.UserFollowService userFollowService) {
        super();
    }
    
    @jakarta.transaction.Transactional()
    public void signUp(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.auth.SignUpRequest request) {
    }
    
    @jakarta.transaction.Transactional()
    @org.jetbrains.annotations.NotNull()
    public com.example.frontServer.dto.user.response.UserProfileGetResult findMainUserProfile(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.user.request.UserProfileGetRequest request) {
        return null;
    }
}