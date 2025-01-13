package com.example.frontServer.service.timeline;

@org.springframework.stereotype.Service()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0012J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0012J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0012J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0012J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/example/frontServer/service/timeline/TimelineBoardService;", "", "boardRepository", "Lcom/example/frontServer/repository/board/BoardRepository;", "timelineService", "Lcom/example/frontServer/service/timeline/TimelineApiService;", "likeApiService", "Lcom/example/frontServer/service/like/LikeApiService;", "userRepository", "Lcom/example/frontServer/repository/user/UserRepository;", "(Lcom/example/frontServer/repository/board/BoardRepository;Lcom/example/frontServer/service/timeline/TimelineApiService;Lcom/example/frontServer/service/like/LikeApiService;Lcom/example/frontServer/repository/user/UserRepository;)V", "fetchInitBoardIds", "", "", "request", "Lcom/example/frontServer/dto/timeline/request/TimelineGetRequest;", "fetchLikeCount", "boardId", "fetchNextBoardIds", "fetchPrevBoardIds", "findTimelineInit", "Lcom/example/frontServer/dto/timeline/response/TimelineBoardGetResult;", "findTimelineNext", "findTimelinePrev", "frontServer"})
public class TimelineBoardService {
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.repository.board.BoardRepository boardRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.service.timeline.TimelineApiService timelineService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.service.like.LikeApiService likeApiService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.repository.user.UserRepository userRepository = null;
    
    public TimelineBoardService(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.repository.board.BoardRepository boardRepository, @org.jetbrains.annotations.NotNull()
    com.example.frontServer.service.timeline.TimelineApiService timelineService, @org.jetbrains.annotations.NotNull()
    com.example.frontServer.service.like.LikeApiService likeApiService, @org.jetbrains.annotations.NotNull()
    com.example.frontServer.repository.user.UserRepository userRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.util.List<com.example.frontServer.dto.timeline.response.TimelineBoardGetResult> findTimelineInit(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.timeline.request.TimelineGetRequest request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.util.List<com.example.frontServer.dto.timeline.response.TimelineBoardGetResult> findTimelineNext(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.timeline.request.TimelineGetRequest request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.util.List<com.example.frontServer.dto.timeline.response.TimelineBoardGetResult> findTimelinePrev(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.timeline.request.TimelineGetRequest request) {
        return null;
    }
    
    private java.util.List<java.lang.Long> fetchInitBoardIds(com.example.frontServer.dto.timeline.request.TimelineGetRequest request) {
        return null;
    }
    
    private java.util.List<java.lang.Long> fetchNextBoardIds(com.example.frontServer.dto.timeline.request.TimelineGetRequest request) {
        return null;
    }
    
    private java.util.List<java.lang.Long> fetchPrevBoardIds(com.example.frontServer.dto.timeline.request.TimelineGetRequest request) {
        return null;
    }
    
    private long fetchLikeCount(long boardId) {
        return 0L;
    }
}