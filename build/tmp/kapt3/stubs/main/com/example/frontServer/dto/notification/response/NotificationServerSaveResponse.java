package com.example.frontServer.dto.notification.response;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/example/frontServer/dto/notification/response/NotificationServerSaveResponse;", "Lcom/example/frontServer/dto/error/MSAServerErrorResponse;", "savedRow", "", "errorDetails", "Lcom/example/frontServer/dto/error/MSAServerErrorDetails;", "errorCode", "Lcom/example/frontServer/enum/MSAServerErrorCode;", "(ILcom/example/frontServer/dto/error/MSAServerErrorDetails;Lcom/example/frontServer/enum/MSAServerErrorCode;)V", "getErrorCode", "()Lcom/example/frontServer/enum/MSAServerErrorCode;", "getErrorDetails", "()Lcom/example/frontServer/dto/error/MSAServerErrorDetails;", "getSavedRow", "()I", "frontServer"})
public final class NotificationServerSaveResponse extends com.example.frontServer.dto.error.MSAServerErrorResponse {
    private final int savedRow = 0;
    @org.jetbrains.annotations.Nullable()
    private final com.example.frontServer.dto.error.MSAServerErrorDetails errorDetails = null;
    
    public final int getSavedRow() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public com.example.frontServer.dto.error.MSAServerErrorDetails getErrorDetails() {
        return null;
    }
}