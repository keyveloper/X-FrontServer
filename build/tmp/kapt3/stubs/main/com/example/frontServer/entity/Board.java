package com.example.frontServer.entity;

@jakarta.persistence.Entity()
@jakarta.persistence.Table(name = "boards")
@jakarta.persistence.EntityListeners(value = {org.springframework.data.jpa.domain.support.AuditingEntityListener.class})
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0007\u0018\u00002\u00020\u0001Be\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fR \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001e\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0015\"\u0004\b*\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010&\u00a8\u0006,"}, d2 = {"Lcom/example/frontServer/entity/Board;", "", "id", "", "writerId", "textContent", "", "fileApiUrl", "createdAt", "Ljava/time/LocalDateTime;", "lastModifiedAt", "readingCount", "parentId", "invalid", "", "(Ljava/lang/Long;JLjava/lang/String;Ljava/lang/String;Ljava/time/LocalDateTime;Ljava/time/LocalDateTime;JLjava/lang/Long;Z)V", "getCreatedAt", "()Ljava/time/LocalDateTime;", "setCreatedAt", "(Ljava/time/LocalDateTime;)V", "getFileApiUrl", "()Ljava/lang/String;", "setFileApiUrl", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getInvalid", "()Z", "setInvalid", "(Z)V", "getLastModifiedAt", "setLastModifiedAt", "getParentId", "setParentId", "getReadingCount", "()J", "setReadingCount", "(J)V", "getTextContent", "setTextContent", "getWriterId", "frontServer"})
public final class Board {
    @jakarta.persistence.Id()
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @org.jetbrains.annotations.Nullable()
    private java.lang.Long id;
    private final long writerId = 0L;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String textContent;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String fileApiUrl;
    @org.springframework.data.annotation.CreatedDate()
    @org.jetbrains.annotations.Nullable()
    private java.time.LocalDateTime createdAt;
    @org.springframework.data.annotation.LastModifiedDate()
    @org.jetbrains.annotations.Nullable()
    private java.time.LocalDateTime lastModifiedAt;
    private long readingCount;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Long parentId;
    private boolean invalid;
    
    public Board(@org.jetbrains.annotations.Nullable()
    java.lang.Long id, long writerId, @org.jetbrains.annotations.NotNull()
    java.lang.String textContent, @org.jetbrains.annotations.Nullable()
    java.lang.String fileApiUrl, @org.jetbrains.annotations.Nullable()
    java.time.LocalDateTime createdAt, @org.jetbrains.annotations.Nullable()
    java.time.LocalDateTime lastModifiedAt, long readingCount, @org.jetbrains.annotations.Nullable()
    java.lang.Long parentId, boolean invalid) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0) {
    }
    
    public final long getWriterId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTextContent() {
        return null;
    }
    
    public final void setTextContent(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFileApiUrl() {
        return null;
    }
    
    public final void setFileApiUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.LocalDateTime getCreatedAt() {
        return null;
    }
    
    public final void setCreatedAt(@org.jetbrains.annotations.Nullable()
    java.time.LocalDateTime p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.LocalDateTime getLastModifiedAt() {
        return null;
    }
    
    public final void setLastModifiedAt(@org.jetbrains.annotations.Nullable()
    java.time.LocalDateTime p0) {
    }
    
    public final long getReadingCount() {
        return 0L;
    }
    
    public final void setReadingCount(long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getParentId() {
        return null;
    }
    
    public final void setParentId(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0) {
    }
    
    public final boolean getInvalid() {
        return false;
    }
    
    public final void setInvalid(boolean p0) {
    }
}