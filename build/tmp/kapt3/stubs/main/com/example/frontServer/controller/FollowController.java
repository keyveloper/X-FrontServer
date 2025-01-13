package com.example.frontServer.controller;

@org.springframework.web.bind.annotation.RestController()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/example/frontServer/controller/FollowController;", "", "followService", "Lcom/example/frontServer/service/follow/FollowService;", "(Lcom/example/frontServer/service/follow/FollowService;)V", "save", "Lorg/springframework/http/ResponseEntity;", "Ljava/lang/Void;", "request", "Lcom/example/frontServer/dto/follow/FollowSaveRequest;", "user", "Lcom/example/frontServer/security/AuthUserDetails;", "frontServer"})
public class FollowController {
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.service.follow.FollowService followService = null;
    
    public FollowController(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.service.follow.FollowService followService) {
        super();
    }
    
    @org.springframework.web.bind.annotation.PostMapping(value = {"/follow"})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<java.lang.Void> save(@org.springframework.web.bind.annotation.RequestBody()
    @org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.follow.FollowSaveRequest request, @org.springframework.security.core.annotation.AuthenticationPrincipal()
    @org.jetbrains.annotations.NotNull()
    com.example.frontServer.security.AuthUserDetails user) {
        return null;
    }
}