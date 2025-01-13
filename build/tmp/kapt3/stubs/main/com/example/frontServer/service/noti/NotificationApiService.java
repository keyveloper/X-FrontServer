package com.example.frontServer.service.noti;

@org.springframework.stereotype.Service()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0010H\u0017J\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u0010H\u0017J\u001e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u0010H\u0017J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u00102\u0006\u0010 \u001a\u00020\u0019H\u0012J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0019H\u0012J&\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%H\u0016J&\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010\'\u001a\u00020(H\u0012J\u001c\u0010)\u001a\u00020(2\n\u0010*\u001a\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010$\u001a\u00020%H\u0016J\u0016\u0010+\u001a\u00020(2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0\u0016H\u0017J\u0018\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010/\u001a\u00020(2\u0006\u0010.\u001a\u00020\u0010H\u0017R\u000e\u0010\u000f\u001a\u00020\u0010X\u0092D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/example/frontServer/service/noti/NotificationApiService;", "", "webConfig", "Lcom/example/frontServer/config/WebConfig;", "circuitBreakerRegistry", "Lio/github/resilience4j/circuitbreaker/CircuitBreakerRegistry;", "userRepository", "Lcom/example/frontServer/repository/user/UserRepository;", "boardRepository", "Lcom/example/frontServer/repository/board/BoardRepository;", "messageService", "Lcom/example/frontServer/service/noti/MessageService;", "notificationProducer", "Lcom/example/frontServer/service/noti/NotificationKafkaProducer;", "(Lcom/example/frontServer/config/WebConfig;Lio/github/resilience4j/circuitbreaker/CircuitBreakerRegistry;Lcom/example/frontServer/repository/user/UserRepository;Lcom/example/frontServer/repository/board/BoardRepository;Lcom/example/frontServer/service/noti/MessageService;Lcom/example/frontServer/service/noti/NotificationKafkaProducer;)V", "baseUrl", "", "circuitBreaker", "Lio/github/resilience4j/circuitbreaker/CircuitBreaker;", "logger", "Lio/github/oshai/kotlinlogging/KLogger;", "fetchInitAll", "", "Lcom/example/frontServer/dto/notification/response/NotificationGetResult;", "receiverId", "", "language", "fetchNextAll", "getRequest", "Lcom/example/frontServer/dto/notification/request/NotificationGetRequest;", "fetchPrevAll", "findUserImgUrlById", "id", "findUserNameById", "getInitFallbackMethod", "Lcom/example/frontServer/dto/notification/response/NotificationGetServerResponse;", "throwable", "", "getScrollFallbackMethod", "logCircuitBreakerInfo", "", "saveFallbackMethod", "requests", "saveRequest", "Lcom/example/frontServer/dto/notification/request/NotificationSaveRequest;", "testKafkaFallbackMethod", "message", "testKafkaPublish", "frontServer"})
public class NotificationApiService {
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.config.WebConfig webConfig = null;
    @org.jetbrains.annotations.NotNull()
    private final io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry circuitBreakerRegistry = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.repository.user.UserRepository userRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.repository.board.BoardRepository boardRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.service.noti.MessageService messageService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.service.noti.NotificationKafkaProducer notificationProducer = null;
    @org.jetbrains.annotations.NotNull()
    private final io.github.resilience4j.circuitbreaker.CircuitBreaker circuitBreaker = null;
    @org.jetbrains.annotations.NotNull()
    private final io.github.oshai.kotlinlogging.KLogger logger = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String baseUrl = "http://localhost:8081";
    
    public NotificationApiService(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.config.WebConfig webConfig, @org.jetbrains.annotations.NotNull()
    io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry circuitBreakerRegistry, @org.jetbrains.annotations.NotNull()
    com.example.frontServer.repository.user.UserRepository userRepository, @org.jetbrains.annotations.NotNull()
    com.example.frontServer.repository.board.BoardRepository boardRepository, @org.jetbrains.annotations.NotNull()
    com.example.frontServer.service.noti.MessageService messageService, @org.jetbrains.annotations.NotNull()
    com.example.frontServer.service.noti.NotificationKafkaProducer notificationProducer) {
        super();
    }
    
    @io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker(name = "notificationApiCircuitBreaker", fallbackMethod = "saveFallbackMethod")
    public void saveRequest(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.frontServer.dto.notification.request.NotificationSaveRequest> requests) {
    }
    
    @io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker(name = "notificationApiCircuitBreaker", fallbackMethod = "getInitFallbackMethod")
    @org.springframework.transaction.annotation.Transactional()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<com.example.frontServer.dto.notification.response.NotificationGetResult> fetchInitAll(long receiverId, @org.jetbrains.annotations.NotNull()
    java.lang.String language) {
        return null;
    }
    
    @org.springframework.transaction.annotation.Transactional()
    @io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker(name = "notificationApiCircuitBreaker", fallbackMethod = "getScrollFallbackMethod")
    @org.jetbrains.annotations.NotNull()
    public java.util.List<com.example.frontServer.dto.notification.response.NotificationGetResult> fetchPrevAll(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.notification.request.NotificationGetRequest getRequest, @org.jetbrains.annotations.NotNull()
    java.lang.String language) {
        return null;
    }
    
    @org.springframework.transaction.annotation.Transactional()
    @io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker(name = "notificationApiCircuitBreaker", fallbackMethod = "getScrollFallbackMethod")
    @org.jetbrains.annotations.NotNull()
    public java.util.List<com.example.frontServer.dto.notification.response.NotificationGetResult> fetchNextAll(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.notification.request.NotificationGetRequest getRequest, @org.jetbrains.annotations.NotNull()
    java.lang.String language) {
        return null;
    }
    
    private java.lang.String findUserNameById(long id) {
        return null;
    }
    
    private java.lang.String findUserImgUrlById(long id) {
        return null;
    }
    
    @io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker(name = "notificationApiCircuitBreaker", fallbackMethod = "testKafkaFallbackMethod")
    public void testKafkaPublish(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    public void testKafkaFallbackMethod(@org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    java.lang.Throwable throwable) {
    }
    
    public void saveFallbackMethod(@org.jetbrains.annotations.NotNull()
    java.util.List<?> requests, @org.jetbrains.annotations.NotNull()
    java.lang.Throwable throwable) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.util.List<com.example.frontServer.dto.notification.response.NotificationGetServerResponse> getInitFallbackMethod(long receiverId, @org.jetbrains.annotations.NotNull()
    java.lang.String language, @org.jetbrains.annotations.NotNull()
    java.lang.Throwable throwable) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.util.List<com.example.frontServer.dto.notification.response.NotificationGetServerResponse> getScrollFallbackMethod(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.notification.request.NotificationGetRequest getRequest, @org.jetbrains.annotations.NotNull()
    java.lang.String language, @org.jetbrains.annotations.NotNull()
    java.lang.Throwable throwable) {
        return null;
    }
    
    private void logCircuitBreakerInfo() {
    }
}