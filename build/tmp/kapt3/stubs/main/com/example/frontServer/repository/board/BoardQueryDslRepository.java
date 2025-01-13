package com.example.frontServer.repository.board;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H&\u00a8\u0006\u000b"}, d2 = {"Lcom/example/frontServer/repository/board/BoardQueryDslRepository;", "", "findInitComment", "", "Lcom/example/frontServer/dto/board/BoardWithCommentCount;", "parentId", "", "findNextComment", "endBoardId", "findTimelineByBoardIds", "Ids", "frontServer"})
public abstract interface BoardQueryDslRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.example.frontServer.dto.board.BoardWithCommentCount> findInitComment(long parentId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.example.frontServer.dto.board.BoardWithCommentCount> findNextComment(long parentId, long endBoardId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.example.frontServer.dto.board.BoardWithCommentCount> findTimelineByBoardIds(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Long> Ids);
}