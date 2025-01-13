package com.example.frontServer.dto.timeline.response;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/example/frontServer/dto/timeline/response/TimelineServerGetResponse;", "", "results", "", "Lcom/example/frontServer/dto/timeline/response/TimelineServerGetResult;", "errorDetails", "Lcom/example/frontServer/dto/error/MSAServerErrorDetails;", "errorCode", "Lcom/example/frontServer/enum/MSAServerErrorCode;", "(Ljava/util/List;Lcom/example/frontServer/dto/error/MSAServerErrorDetails;Lcom/example/frontServer/enum/MSAServerErrorCode;)V", "getErrorCode", "()Lcom/example/frontServer/enum/MSAServerErrorCode;", "getErrorDetails", "()Lcom/example/frontServer/dto/error/MSAServerErrorDetails;", "getResults", "()Ljava/util/List;", "frontServer"})
public final class TimelineServerGetResponse {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.frontServer.dto.timeline.response.TimelineServerGetResult> results = null;
    @org.jetbrains.annotations.Nullable()
    private final com.example.frontServer.dto.error.MSAServerErrorDetails errorDetails = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.frontServer.dto.timeline.response.TimelineServerGetResult> getResults() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.frontServer.dto.error.MSAServerErrorDetails getErrorDetails() {
        return null;
    }
}