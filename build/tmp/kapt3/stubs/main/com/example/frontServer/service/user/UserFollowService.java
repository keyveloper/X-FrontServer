package com.example.frontServer.service.user;

@org.springframework.stereotype.Service()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/frontServer/service/user/UserFollowService;", "", "followerService", "Lcom/example/frontServer/service/follow/FollowService;", "(Lcom/example/frontServer/service/follow/FollowService;)V", "findFollowCount", "Lcom/example/frontServer/dto/follow/FollowCounts;", "id", "", "frontServer"})
public class UserFollowService {
    @org.jetbrains.annotations.NotNull()
    private final com.example.frontServer.service.follow.FollowService followerService = null;
    
    public UserFollowService(@org.jetbrains.annotations.NotNull()
    com.example.frontServer.service.follow.FollowService followerService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.example.frontServer.dto.follow.FollowCounts findFollowCount(long id) {
        return null;
    }
}