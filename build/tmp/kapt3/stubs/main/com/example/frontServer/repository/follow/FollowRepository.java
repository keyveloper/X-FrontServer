package com.example.frontServer.repository.follow;

@org.springframework.stereotype.Repository()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H&\u00a8\u0006\t"}, d2 = {"Lcom/example/frontServer/repository/follow/FollowRepository;", "Lorg/springframework/data/jpa/repository/JpaRepository;", "Lcom/example/frontServer/entity/Follow;", "", "Lcom/example/frontServer/repository/follow/FollowQueryDslRepository;", "findByFollowingIdAndFollowerId", "Ljava/util/Optional;", "followingId", "followerId", "frontServer"})
public abstract interface FollowRepository extends org.springframework.data.jpa.repository.JpaRepository<com.example.frontServer.entity.Follow, java.lang.Long>, com.example.frontServer.repository.follow.FollowQueryDslRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.Optional<com.example.frontServer.entity.Follow> findByFollowingIdAndFollowerId(long followingId, long followerId);
}