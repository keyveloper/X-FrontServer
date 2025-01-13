package com.example.frontServer.service.board;

@org.springframework.stereotype.Service()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0012J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0012J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0017J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\"H\u0016J \u0010#\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\'H\u0017J\u0016\u0010(\u001a\u00020\u00122\f\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u001bH\u0012J\u001e\u0010+\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00172\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00170\u001bH\u0012J\u0012\u0010-\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001d\u001a\u00020.H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/example/frontServer/service/board/BoardService;", "", "boardRepository", "Lcom/example/frontServer/repository/board/BoardRepository;", "notificationService", "Lcom/example/frontServer/service/noti/NotificationApiService;", "fileService", "Lcom/example/frontServer/service/FileService;", "followRepository", "Lcom/example/frontServer/repository/follow/FollowRepository;", "likeApiService", "Lcom/example/frontServer/service/like/LikeApiService;", "timelineApiService", "Lcom/example/frontServer/service/timeline/TimelineApiService;", "userRepository", "Lcom/example/frontServer/repository/user/UserRepository;", "(Lcom/example/frontServer/repository/board/BoardRepository;Lcom/example/frontServer/service/noti/NotificationApiService;Lcom/example/frontServer/service/FileService;Lcom/example/frontServer/repository/follow/FollowRepository;Lcom/example/frontServer/service/like/LikeApiService;Lcom/example/frontServer/service/timeline/TimelineApiService;Lcom/example/frontServer/repository/user/UserRepository;)V", "addReadingCount", "", "board", "Lcom/example/frontServer/entity/Board;", "deleteById", "id", "", "fetchLikeCount", "boardId", "findInitComment", "", "Lcom/example/frontServer/dto/board/response/CommentResult;", "request", "Lcom/example/frontServer/dto/board/request/CommentGetRequest;", "findNextComment", "findSingleBoard", "Lcom/example/frontServer/dto/board/response/SingleBoardResult;", "Lcom/example/frontServer/dto/board/request/SingleBoardRequest;", "save", "Lcom/example/frontServer/dto/board/request/BoardSaveRequest;", "writerId", "writerName", "", "saveNotification", "requests", "Lcom/example/frontServer/dto/notification/request/NotificationSaveRequest;", "saveTimeline", "receivers", "updateContentById", "Lcom/example/frontServer/dto/board/request/BoardUpdateRequest;", "frontServer"})
public class BoardService {
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.repository.board.BoardRepository boardRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.service.noti.NotificationApiService notificationService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.service.FileService fileService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.repository.follow.FollowRepository followRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.service.like.LikeApiService likeApiService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.service.timeline.TimelineApiService timelineApiService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.repository.user.UserRepository userRepository = null;
    
    public BoardService(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.repository.board.BoardRepository boardRepository, @org.jetbrains.annotations.NotNull()
    com.example.frontServer.service.noti.NotificationApiService notificationService, @org.jetbrains.annotations.NotNull()
    com.example.frontServer.service.FileService fileService, @org.jetbrains.annotations.NotNull()
    com.example.frontServer.repository.follow.FollowRepository followRepository, @org.jetbrains.annotations.NotNull()
    com.example.frontServer.service.like.LikeApiService likeApiService, @org.jetbrains.annotations.NotNull()
    com.example.frontServer.service.timeline.TimelineApiService timelineApiService, @org.jetbrains.annotations.NotNull()
    com.example.frontServer.repository.user.UserRepository userRepository) {
        super();
    }
    
    @jakarta.transaction.Transactional()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<com.example.frontServer.dto.board.response.CommentResult> findInitComment(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.board.request.CommentGetRequest request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.util.List<com.example.frontServer.dto.board.response.CommentResult> findNextComment(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.board.request.CommentGetRequest request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.example.frontServer.dto.board.response.SingleBoardResult findSingleBoard(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.board.request.SingleBoardRequest request) {
        return null;
    }
    
    @jakarta.transaction.Transactional()
    public void save(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.board.request.BoardSaveRequest request, long writerId, @org.jetbrains.annotations.NotNull()
    java.lang.String writerName) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public com.example.frontServer.entity.Board deleteById(long id) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public com.example.frontServer.entity.Board updateContentById(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.board.request.BoardUpdateRequest request) {
        return null;
    }
    
    private void saveTimeline(long boardId, java.util.List<java.lang.Long> receivers) {
    }
    
    private void addReadingCount(com.example.frontServer.entity.Board board) {
    }
    
    private void saveNotification(java.util.List<com.example.frontServer.dto.notification.request.NotificationSaveRequest> requests) {
    }
    
    private long fetchLikeCount(long boardId) {
        return 0L;
    }
}