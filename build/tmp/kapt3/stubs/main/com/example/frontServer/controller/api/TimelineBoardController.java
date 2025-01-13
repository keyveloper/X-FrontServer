package com.example.frontServer.controller.api;

@org.springframework.web.bind.annotation.RestController()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\b\u001a\u00020\tH\u0017J\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\b\u001a\u00020\tH\u0017J\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\b\u001a\u00020\tH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/example/frontServer/controller/api/TimelineBoardController;", "", "timelineBoardService", "Lcom/example/frontServer/service/timeline/TimelineBoardService;", "(Lcom/example/frontServer/service/timeline/TimelineBoardService;)V", "findTimelineBefore", "Lorg/springframework/http/ResponseEntity;", "Lcom/example/frontServer/dto/timeline/response/TimelineBoardGetResponse;", "request", "Lcom/example/frontServer/dto/timeline/request/TimelineGetRequest;", "findTimelineInit", "findTimelineNext", "frontServer"})
public class TimelineBoardController {
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.service.timeline.TimelineBoardService timelineBoardService = null;
    
    public TimelineBoardController(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.service.timeline.TimelineBoardService timelineBoardService) {
        super();
    }
    
    @org.springframework.web.bind.annotation.PostMapping(value = {"/getTimeline/init"})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<com.example.frontServer.dto.timeline.response.TimelineBoardGetResponse> findTimelineInit(@jakarta.validation.Valid()
    @org.springframework.web.bind.annotation.RequestBody()
    @org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.timeline.request.TimelineGetRequest request) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.PostMapping(value = {"/getTimeline/next"})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<com.example.frontServer.dto.timeline.response.TimelineBoardGetResponse> findTimelineNext(@org.springframework.web.bind.annotation.RequestBody()
    @org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.timeline.request.TimelineGetRequest request) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.PostMapping(value = {"/getTimeline/prev"})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<com.example.frontServer.dto.timeline.response.TimelineBoardGetResponse> findTimelineBefore(@org.springframework.web.bind.annotation.RequestBody()
    @org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.timeline.request.TimelineGetRequest request) {
        return null;
    }
}