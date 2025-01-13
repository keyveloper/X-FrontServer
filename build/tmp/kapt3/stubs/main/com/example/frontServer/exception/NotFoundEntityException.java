package com.example.frontServer.exception;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/example/frontServer/exception/NotFoundEntityException;", "Lcom/example/frontServer/exception/BusinessException;", "httpStatus", "Lorg/springframework/http/HttpStatus;", "message", "", "(Lorg/springframework/http/HttpStatus;Ljava/lang/String;)V", "getHttpStatus", "()Lorg/springframework/http/HttpStatus;", "getMessage", "()Ljava/lang/String;", "frontServer"})
public final class NotFoundEntityException extends com.example.frontServer.exception.BusinessException {
    @org.jetbrains.annotations.NotNull()
    private final org.springframework.http.HttpStatus httpStatus = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String message = null;
    
    public NotFoundEntityException(@org.jetbrains.annotations.NotNull()
    org.springframework.http.HttpStatus httpStatus, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
        super(null, null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.springframework.http.HttpStatus getHttpStatus() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getMessage() {
        return null;
    }
}