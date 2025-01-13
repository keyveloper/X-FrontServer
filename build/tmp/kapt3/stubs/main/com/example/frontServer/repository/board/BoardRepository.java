package com.example.frontServer.repository.board;

@org.springframework.stereotype.Repository()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0003H\'\u00a8\u0006\b"}, d2 = {"Lcom/example/frontServer/repository/board/BoardRepository;", "Lorg/springframework/data/jpa/repository/JpaRepository;", "Lcom/example/frontServer/entity/Board;", "", "Lcom/example/frontServer/repository/board/BoardQueryDslRepository;", "deleteBoardById", "", "id", "frontServer"})
public abstract interface BoardRepository extends org.springframework.data.jpa.repository.JpaRepository<com.example.frontServer.entity.Board, java.lang.Long>, com.example.frontServer.repository.board.BoardQueryDslRepository {
    
    @org.springframework.data.jpa.repository.Modifying()
    @org.springframework.transaction.annotation.Transactional()
    @org.springframework.data.jpa.repository.Query(value = "UPDATE Board b SET b.invalid = TRUE where b.id = :id")
    public abstract int deleteBoardById(@org.springframework.data.repository.query.Param(value = "id")
    long id);
}