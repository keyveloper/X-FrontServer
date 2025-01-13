package com.example.frontServer.controller;

@org.springframework.web.bind.annotation.RestController()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0017J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\u0006H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/example/frontServer/controller/TestController;", "", "notificationApiService", "Lcom/example/frontServer/service/noti/NotificationApiService;", "(Lcom/example/frontServer/service/noti/NotificationApiService;)V", "test", "", "testKafkaPublish", "", "message", "frontServer"})
public class TestController {
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.service.noti.NotificationApiService notificationApiService = null;
    
    public TestController(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.service.noti.NotificationApiService notificationApiService) {
        super();
    }
    
    @org.springframework.web.bind.annotation.GetMapping(value = {"/test"})
    @org.jetbrains.annotations.NotNull()
    public java.lang.String test() {
        return null;
    }
    
    @org.springframework.web.bind.annotation.PostMapping(value = {"/test/kafka"})
    public void testKafkaPublish(@org.springframework.web.bind.annotation.RequestBody()
    @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
}