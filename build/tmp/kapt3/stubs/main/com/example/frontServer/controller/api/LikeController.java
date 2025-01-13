package com.example.frontServer.controller.api;

@org.springframework.web.bind.annotation.RestController()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/example/frontServer/controller/api/LikeController;", "", "likeService", "Lcom/example/frontServer/service/like/LikeApiService;", "(Lcom/example/frontServer/service/like/LikeApiService;)V", "logger", "Lio/github/oshai/kotlinlogging/KLogger;", "save", "Lorg/springframework/http/ResponseEntity;", "", "likeRequest", "Lcom/example/frontServer/dto/like/request/LikeSaveRequest;", "user", "Lcom/example/frontServer/security/AuthUserDetails;", "frontServer"})
public class LikeController {
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.service.like.LikeApiService likeService = null;
    @org.jetbrains.annotations.NotNull()
    private final io.github.oshai.kotlinlogging.KLogger logger = null;
    
    public LikeController(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.service.like.LikeApiService likeService) {
        super();
    }
    
    @org.springframework.web.bind.annotation.PostMapping(value = {"/like"})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<java.lang.String> save(@jakarta.validation.Valid()
    @org.springframework.web.bind.annotation.RequestBody()
    @org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.like.request.LikeSaveRequest likeRequest, @org.springframework.security.core.annotation.AuthenticationPrincipal()
    @org.jetbrains.annotations.NotNull()
    com.example.frontServer.security.AuthUserDetails user) {
        return null;
    }
}