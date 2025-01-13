package com.example.frontServer.service.follow;

@org.springframework.stereotype.Service()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0017J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/frontServer/service/follow/FollowService;", "", "followRepository", "Lcom/example/frontServer/repository/follow/FollowRepository;", "userRepository", "Lcom/example/frontServer/repository/user/UserRepository;", "notificationApiService", "Lcom/example/frontServer/service/noti/NotificationApiService;", "(Lcom/example/frontServer/repository/follow/FollowRepository;Lcom/example/frontServer/repository/user/UserRepository;Lcom/example/frontServer/service/noti/NotificationApiService;)V", "findFollowCounts", "Lcom/example/frontServer/dto/follow/FollowCounts;", "targetId", "", "save", "", "request", "Lcom/example/frontServer/dto/follow/FollowSaveRequest;", "followerId", "unFollow", "followTargetId", "frontServer"})
public class FollowService {
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.repository.follow.FollowRepository followRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.repository.user.UserRepository userRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.service.noti.NotificationApiService notificationApiService = null;
    
    public FollowService(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.repository.follow.FollowRepository followRepository, @org.jetbrains.annotations.NotNull()
    com.example.frontServer.repository.user.UserRepository userRepository, @org.jetbrains.annotations.NotNull()
    com.example.frontServer.service.noti.NotificationApiService notificationApiService) {
        super();
    }
    
    @jakarta.transaction.Transactional()
    public void save(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.dto.follow.FollowSaveRequest request, long followerId) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.example.frontServer.dto.follow.FollowCounts findFollowCounts(long targetId) {
        return null;
    }
    
    public void unFollow(long followTargetId, long followerId) {
    }
}