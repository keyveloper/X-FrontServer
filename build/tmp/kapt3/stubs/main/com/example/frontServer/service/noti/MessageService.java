package com.example.frontServer.service.noti;

@org.springframework.stereotype.Component()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J9\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0016\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/frontServer/service/noti/MessageService;", "", "messageSource", "Lorg/springframework/context/MessageSource;", "(Lorg/springframework/context/MessageSource;)V", "makeMessage", "", "notiType", "Lcom/example/frontServer/enum/NotificationType;", "targetBoard", "Lcom/example/frontServer/entity/Board;", "targetBoardId", "", "username", "language", "(Lcom/example/frontServer/enum/NotificationType;Lcom/example/frontServer/entity/Board;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "frontServer"})
public class MessageService {
    @org.jetbrains.annotations.NotNull()
    private final org.springframework.context.MessageSource messageSource = null;
    
    public MessageService(@org.jetbrains.annotations.NotNull()
    org.springframework.context.MessageSource messageSource) {
        super();
    }
}