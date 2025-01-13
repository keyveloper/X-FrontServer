package com.example.frontServer.entity;

@jakarta.persistence.Entity()
@jakarta.persistence.Table(name = "user_roles", uniqueConstraints = {@jakarta.persistence.UniqueConstraint(columnNames = {"user_id", "role_id"})})
@jakarta.persistence.EntityListeners(value = {org.springframework.data.jpa.domain.support.AuditingEntityListener.class})
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B-\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bR \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/example/frontServer/entity/UserRole;", "", "id", "", "user", "role", "createdAt", "Ljava/time/LocalDateTime;", "(Ljava/lang/Long;JJLjava/time/LocalDateTime;)V", "getCreatedAt", "()Ljava/time/LocalDateTime;", "setCreatedAt", "(Ljava/time/LocalDateTime;)V", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getRole", "()J", "setRole", "(J)V", "getUser", "setUser", "frontServer"})
public final class UserRole {
    @jakarta.persistence.Id()
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @org.jetbrains.annotations.Nullable()
    private java.lang.Long id;
    @jakarta.persistence.Column(name = "user_id", nullable = false)
    private long user;
    @jakarta.persistence.Column(name = "role_id", nullable = false)
    private long role;
    @jakarta.persistence.Column(name = "created_at")
    @org.springframework.data.annotation.CreatedDate()
    @org.jetbrains.annotations.Nullable()
    private java.time.LocalDateTime createdAt;
    
    public UserRole(@org.jetbrains.annotations.Nullable()
    java.lang.Long id, long user, long role, @org.jetbrains.annotations.Nullable()
    java.time.LocalDateTime createdAt) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0) {
    }
    
    public final long getUser() {
        return 0L;
    }
    
    public final void setUser(long p0) {
    }
    
    public final long getRole() {
        return 0L;
    }
    
    public final void setRole(long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.LocalDateTime getCreatedAt() {
        return null;
    }
    
    public final void setCreatedAt(@org.jetbrains.annotations.Nullable()
    java.time.LocalDateTime p0) {
    }
}