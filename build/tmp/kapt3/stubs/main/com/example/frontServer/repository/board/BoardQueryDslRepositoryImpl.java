package com.example.frontServer.repository.board;

@org.springframework.stereotype.Repository()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eH\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u0092\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0007R\u0016\u0010\b\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lcom/example/frontServer/repository/board/BoardQueryDslRepositoryImpl;", "Lcom/example/frontServer/repository/board/BoardQueryDslRepository;", "queryFactory", "Lcom/querydsl/jpa/impl/JPAQueryFactory;", "(Lcom/querydsl/jpa/impl/JPAQueryFactory;)V", "board", "error/NonExistentClass", "Lerror/NonExistentClass;", "comment", "getComment", "()Lerror/NonExistentClass;", "getQueryFactory", "()Lcom/querydsl/jpa/impl/JPAQueryFactory;", "findInitComment", "", "Lcom/example/frontServer/dto/board/BoardWithCommentCount;", "parentId", "", "findNextComment", "endBoardId", "findTimelineByBoardIds", "ids", "frontServer"})
public class BoardQueryDslRepositoryImpl implements com.example.frontServer.repository.board.BoardQueryDslRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.querydsl.jpa.impl.JPAQueryFactory queryFactory = null;
    @org.jetbrains.annotations.NotNull()
    private final error.NonExistentClass board = null;
    @org.jetbrains.annotations.NotNull()
    private final error.NonExistentClass comment = null;
    
    public BoardQueryDslRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.querydsl.jpa.impl.JPAQueryFactory queryFactory) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.querydsl.jpa.impl.JPAQueryFactory getQueryFactory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public error.NonExistentClass getComment() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<com.example.frontServer.dto.board.BoardWithCommentCount> findInitComment(long parentId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<com.example.frontServer.dto.board.BoardWithCommentCount> findNextComment(long parentId, long endBoardId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<com.example.frontServer.dto.board.BoardWithCommentCount> findTimelineByBoardIds(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Long> ids) {
        return null;
    }
}