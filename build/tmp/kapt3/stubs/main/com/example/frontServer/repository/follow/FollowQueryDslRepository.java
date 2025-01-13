package com.example.frontServer.repository.follow;

@org.springframework.stereotype.Repository()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\t"}, d2 = {"Lcom/example/frontServer/repository/follow/FollowQueryDslRepository;", "", "findFollowCounts", "Lcom/example/frontServer/dto/follow/FollowCounts;", "targetUserId", "", "findFollowersById", "", "Lcom/example/frontServer/entity/Follow;", "frontServer"})
public abstract interface FollowQueryDslRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.frontServer.dto.follow.FollowCounts findFollowCounts(long targetUserId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.example.frontServer.entity.Follow> findFollowersById(long targetUserId);
}