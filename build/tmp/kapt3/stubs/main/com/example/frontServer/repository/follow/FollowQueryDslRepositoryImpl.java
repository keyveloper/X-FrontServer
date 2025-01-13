package com.example.frontServer.repository.follow;

@org.springframework.stereotype.Repository()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u0092\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u00020\u0006X\u0092\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/frontServer/repository/follow/FollowQueryDslRepositoryImpl;", "Lcom/example/frontServer/repository/follow/FollowQueryDslRepository;", "queryFactory", "Lcom/querydsl/jpa/impl/JPAQueryFactory;", "(Lcom/querydsl/jpa/impl/JPAQueryFactory;)V", "follow", "error/NonExistentClass", "Lerror/NonExistentClass;", "qUser", "findFollowCounts", "Lcom/example/frontServer/dto/follow/FollowCounts;", "targetUserId", "", "findFollowersById", "", "Lcom/example/frontServer/entity/Follow;", "frontServer"})
public class FollowQueryDslRepositoryImpl implements com.example.frontServer.repository.follow.FollowQueryDslRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.querydsl.jpa.impl.JPAQueryFactory queryFactory = null;
    @org.jetbrains.annotations.NotNull()
    private final error.NonExistentClass follow = null;
    @org.jetbrains.annotations.NotNull()
    private final error.NonExistentClass qUser = null;
    
    public FollowQueryDslRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.querydsl.jpa.impl.JPAQueryFactory queryFactory) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.example.frontServer.dto.follow.FollowCounts findFollowCounts(long targetUserId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<com.example.frontServer.entity.Follow> findFollowersById(long targetUserId) {
        return null;
    }
}