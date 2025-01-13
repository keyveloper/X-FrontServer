package com.example.frontServer.dto.board.request;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/example/frontServer/dto/board/request/SaveReplyRequest;", "", "textContent", "", "imgFile", "Lorg/springframework/web/multipart/MultipartFile;", "parentId", "", "(Ljava/lang/String;Lorg/springframework/web/multipart/MultipartFile;J)V", "getImgFile", "()Lorg/springframework/web/multipart/MultipartFile;", "getParentId", "()J", "getTextContent", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "frontServer"})
public final class SaveReplyRequest {
    @jakarta.validation.constraints.NotEmpty()
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String textContent = null;
    @org.jetbrains.annotations.Nullable()
    private final org.springframework.web.multipart.MultipartFile imgFile = null;
    @jakarta.validation.constraints.NotEmpty()
    private final long parentId = 0L;
    
    public SaveReplyRequest(@org.jetbrains.annotations.NotNull()
    java.lang.String textContent, @org.jetbrains.annotations.Nullable()
    org.springframework.web.multipart.MultipartFile imgFile, long parentId) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTextContent() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.springframework.web.multipart.MultipartFile getImgFile() {
        return null;
    }
    
    public final long getParentId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.springframework.web.multipart.MultipartFile component2() {
        return null;
    }
    
    public final long component3() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.frontServer.dto.board.request.SaveReplyRequest copy(@org.jetbrains.annotations.NotNull()
    java.lang.String textContent, @org.jetbrains.annotations.Nullable()
    org.springframework.web.multipart.MultipartFile imgFile, long parentId) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}