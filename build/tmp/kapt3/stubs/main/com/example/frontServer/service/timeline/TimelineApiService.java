package com.example.frontServer.service.timeline;

@org.springframework.stereotype.Service()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0017J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0017J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0017J\u001e\u0010\u001b\u001a\u00020\u001c2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0016\u0010\u001e\u001a\u00020\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0012H\u0017R\u000e\u0010\u0007\u001a\u00020\bX\u0092D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/example/frontServer/service/timeline/TimelineApiService;", "", "webConfig", "Lcom/example/frontServer/config/WebConfig;", "circuitBreakerRegistry", "Lio/github/resilience4j/circuitbreaker/CircuitBreakerRegistry;", "(Lcom/example/frontServer/config/WebConfig;Lio/github/resilience4j/circuitbreaker/CircuitBreakerRegistry;)V", "baseUrl", "", "circuitBreaker", "Lio/github/resilience4j/circuitbreaker/CircuitBreaker;", "logger", "Lio/github/oshai/kotlinlogging/KLogger;", "timelineWebClient", "Lorg/springframework/web/reactive/function/client/WebClient;", "getTimelineWebClient", "()Lorg/springframework/web/reactive/function/client/WebClient;", "getFallbackMethod", "", "", "request", "Lcom/example/frontServer/dto/timeline/request/TimelineGetRequest;", "t", "", "requestTimelineInitBoardIds", "requestTimelineNextBoardIds", "requestTimelinePrevBoardIds", "saveFallbackMethod", "", "Lcom/example/frontServer/dto/timeline/request/TimelineSaveRequest;", "saveRequest", "requests", "frontServer"})
public class TimelineApiService {
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.config.WebConfig webConfig = null;
    @org.jetbrains.annotations.NotNull()
    private final io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry circuitBreakerRegistry = null;
    @org.jetbrains.annotations.NotNull()
    private final io.github.resilience4j.circuitbreaker.CircuitBreaker circuitBreaker = null;
    @org.jetbrains.annotations.NotNull()
    private final io.github.oshai.kotlinlogging.KLogger logger = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String baseUrl = "http://localhost:8083";
    @org.jetbrains.annotations.NotNull()
    private final org.springframework.web.reactive.function.client.WebClient timelineWebClient = null;
    
    public TimelineApiService(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.config.WebConfig webConfig, @org.jetbrains.annotations.NotNull()
    io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry circuitBreakerRegistry) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public org.springframework.web.reactive.function.client.WebClient getTimelineWebClient() {
        return null;
    }
    
    @io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker(name = "timelineApiCircuitBreaker", fallbackMethod = "saveFallbackMethod")
    public void saveRequest(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.frontServer.dto.timeline.request.TimelineSaveRequest> requests) {
    }
    
    @io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker(name = "timelineApiCircuitBreaker", fallbackMethod = "getFallbackMethod")
    @org.jetbrains.annotations.NotNull()
    public java.util.List<java.lang.Long> requestTimelineInitBoardIds(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.timeline.request.TimelineGetRequest request) {
        return null;
    }
    
    @io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker(name = "timelineApiCircuitBreaker", fallbackMethod = "getFallbackMethod")
    @org.jetbrains.annotations.NotNull()
    public java.util.List<java.lang.Long> requestTimelineNextBoardIds(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.timeline.request.TimelineGetRequest request) {
        return null;
    }
    
    @io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker(name = "timelineApiCircuitBreaker", fallbackMethod = "getFallbackMethod")
    @org.jetbrains.annotations.NotNull()
    public java.util.List<java.lang.Long> requestTimelinePrevBoardIds(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.timeline.request.TimelineGetRequest request) {
        return null;
    }
    
    public void saveFallbackMethod(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.frontServer.dto.timeline.request.TimelineSaveRequest> request, @org.jetbrains.annotations.NotNull()
    java.lang.Throwable t) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.util.List<java.lang.Long> getFallbackMethod(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.timeline.request.TimelineGetRequest request, @org.jetbrains.annotations.NotNull()
    java.lang.Throwable t) {
        return null;
    }
}