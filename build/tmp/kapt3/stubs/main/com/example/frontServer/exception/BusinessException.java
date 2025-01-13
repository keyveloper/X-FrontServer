package com.example.frontServer.exception;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/example/frontServer/exception/BusinessException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "httpStatus", "Lorg/springframework/http/HttpStatus;", "message", "", "(Lorg/springframework/http/HttpStatus;Ljava/lang/String;)V", "getHttpStatus", "()Lorg/springframework/http/HttpStatus;", "getMessage", "()Ljava/lang/String;", "frontServer"})
public class BusinessException extends java.lang.RuntimeException {
    @org.jetbrains.annotations.NotNull()
    private final org.springframework.http.HttpStatus httpStatus = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String message = null;
    
    public BusinessException(@org.jetbrains.annotations.NotNull()
    org.springframework.http.HttpStatus httpStatus, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
        super();
    }
    
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