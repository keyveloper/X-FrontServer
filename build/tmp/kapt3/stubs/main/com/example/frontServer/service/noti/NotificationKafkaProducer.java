package com.example.frontServer.service.noti;

@org.springframework.stereotype.Service()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0092D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/frontServer/service/noti/NotificationKafkaProducer;", "", "kafkaTemplate", "Lorg/springframework/kafka/core/KafkaTemplate;", "", "(Lorg/springframework/kafka/core/KafkaTemplate;)V", "logger", "Lio/github/oshai/kotlinlogging/KLogger;", "topic", "sendNotifications", "", "requests", "", "Lcom/example/frontServer/dto/notification/request/NotificationSaveRequest;", "testKafkaPublish", "message", "frontServer"})
public class NotificationKafkaProducer {
    @org.jetbrains.annotations.NotNull()
    private final org.springframework.kafka.core.KafkaTemplate<java.lang.String, java.lang.Object> kafkaTemplate = null;
    @org.jetbrains.annotations.NotNull()
    private final io.github.oshai.kotlinlogging.KLogger logger = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String topic = "noti";
    
    public NotificationKafkaProducer(@org.jetbrains.annotations.NotNull()
    org.springframework.kafka.core.KafkaTemplate<java.lang.String, java.lang.Object> kafkaTemplate) {
        super();
    }
    
    public void sendNotifications(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.frontServer.dto.notification.request.NotificationSaveRequest> requests) {
    }
    
    public void testKafkaPublish(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
}