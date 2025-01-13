package com.example.frontServer.controller.api;

@org.springframework.web.bind.annotation.RestController()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0017J\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\b\u001a\u00020\r2\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0017J\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\b\u001a\u00020\r2\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/frontServer/controller/api/NotificationController;", "", "notificationService", "Lcom/example/frontServer/service/noti/NotificationApiService;", "(Lcom/example/frontServer/service/noti/NotificationApiService;)V", "findInitAll", "Lorg/springframework/http/ResponseEntity;", "Lcom/example/frontServer/dto/notification/response/NotificationGetResponse;", "request", "Lcom/example/frontServer/dto/notification/request/NotificationGetInitRequest;", "language", "", "findNextAll", "Lcom/example/frontServer/dto/notification/request/NotificationGetRequest;", "findPrevAll", "frontServer"})
public class NotificationController {
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.service.noti.NotificationApiService notificationService = null;
    
    public NotificationController(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.service.noti.NotificationApiService notificationService) {
        super();
    }
    
    @org.springframework.web.bind.annotation.PostMapping(value = {"/getNotification/init"})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<com.example.frontServer.dto.notification.response.NotificationGetResponse> findInitAll(@jakarta.validation.Valid()
    @org.springframework.web.bind.annotation.RequestBody()
    @org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.notification.request.NotificationGetInitRequest request, @org.springframework.web.bind.annotation.RequestHeader(value = "Accept-Language", defaultValue = "en")
    @org.jetbrains.annotations.NotNull()
    java.lang.String language) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.PostMapping(value = {"/getNotification/prev"})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<com.example.frontServer.dto.notification.response.NotificationGetResponse> findPrevAll(@org.springframework.web.bind.annotation.RequestBody()
    @org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.notification.request.NotificationGetRequest request, @org.springframework.web.bind.annotation.RequestHeader(value = "Accept-Language", defaultValue = "en")
    @org.jetbrains.annotations.NotNull()
    java.lang.String language) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.PostMapping(value = {"/getNotification/next"})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<com.example.frontServer.dto.notification.response.NotificationGetResponse> findNextAll(@org.springframework.web.bind.annotation.RequestBody()
    @org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.notification.request.NotificationGetRequest request, @org.springframework.web.bind.annotation.RequestHeader(value = "Accept-Language", defaultValue = "en")
    @org.jetbrains.annotations.NotNull()
    java.lang.String language) {
        return null;
    }
}