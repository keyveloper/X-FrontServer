package com.example.frontServer.service.like;

@org.springframework.stereotype.Service()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0017J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0012J \u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u0010H\u0017R\u000e\u0010\t\u001a\u00020\nX\u0092D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/example/frontServer/service/like/LikeApiService;", "", "webConfig", "Lcom/example/frontServer/config/WebConfig;", "circuitBreakerRegistry", "Lio/github/resilience4j/circuitbreaker/CircuitBreakerRegistry;", "notificationApiService", "Lcom/example/frontServer/service/noti/NotificationApiService;", "(Lcom/example/frontServer/config/WebConfig;Lio/github/resilience4j/circuitbreaker/CircuitBreakerRegistry;Lcom/example/frontServer/service/noti/NotificationApiService;)V", "baseUrl", "", "circuitBreaker", "Lio/github/resilience4j/circuitbreaker/CircuitBreaker;", "logger", "Lio/github/oshai/kotlinlogging/KLogger;", "fetchLikeCountByBoardId", "", "boardId", "findAllByBoardIdFallbackMethod", "", "throwable", "", "likeCountFallbackMethod", "t", "logCircuitBreakerInfo", "", "saveFallbackMethod", "Lcom/example/frontServer/dto/like/response/LikeSaveResult;", "userId", "saveRequest", "likeRequest", "Lcom/example/frontServer/dto/like/request/LikeSaveRequest;", "frontServer"})
public class LikeApiService {
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.config.WebConfig webConfig = null;
    @org.jetbrains.annotations.NotNull()
    private final io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry circuitBreakerRegistry = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.service.noti.NotificationApiService notificationApiService = null;
    @org.jetbrains.annotations.NotNull()
    private final io.github.resilience4j.circuitbreaker.CircuitBreaker circuitBreaker = null;
    @org.jetbrains.annotations.NotNull()
    private final io.github.oshai.kotlinlogging.KLogger logger = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String baseUrl = "http://localhost:8082";
    
    public LikeApiService(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.config.WebConfig webConfig, @org.jetbrains.annotations.NotNull()
    io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry circuitBreakerRegistry, @org.jetbrains.annotations.NotNull()
    com.example.frontServer.service.noti.NotificationApiService notificationApiService) {
        super();
    }
    
    @io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker(name = "likeApiCircuitBreaker", fallbackMethod = "saveFallbackMethod")
    @org.jetbrains.annotations.NotNull()
    public com.example.frontServer.dto.like.response.LikeSaveResult saveRequest(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.like.request.LikeSaveRequest likeRequest, long userId) {
        return null;
    }
    
    @io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker(name = "likeApiCircuitBreaker", fallbackMethod = "likeCountFallback")
    public long fetchLikeCountByBoardId(long boardId) {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.example.frontServer.dto.like.response.LikeSaveResult saveFallbackMethod(long boardId, long userId, @org.jetbrains.annotations.NotNull()
    java.lang.Throwable throwable) {
        return null;
    }
    
    public long likeCountFallbackMethod(long boardId, @org.jetbrains.annotations.NotNull()
    java.lang.Throwable t) {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.util.List<java.lang.Long> findAllByBoardIdFallbackMethod(long boardId, @org.jetbrains.annotations.NotNull()
    java.lang.Throwable throwable) {
        return null;
    }
    
    private void logCircuitBreakerInfo() {
    }
}