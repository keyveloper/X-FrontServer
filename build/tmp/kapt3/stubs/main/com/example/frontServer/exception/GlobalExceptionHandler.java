package com.example.frontServer.exception;

@org.springframework.web.bind.annotation.RestControllerAdvice()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0017\u00a8\u0006\b"}, d2 = {"Lcom/example/frontServer/exception/GlobalExceptionHandler;", "", "()V", "handleBusinessException", "Lorg/springframework/http/ResponseEntity;", "", "ex", "Lcom/example/frontServer/exception/BusinessException;", "frontServer"})
public class GlobalExceptionHandler {
    
    public GlobalExceptionHandler() {
        super();
    }
    
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {com.example.frontServer.exception.BusinessException.class})
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.ResponseEntity<java.lang.String> handleBusinessException(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.exception.BusinessException ex) {
        return null;
    }
}