package com.example.frontServer.repository.follow

import com.example.frontServer.dto.follow.FollowCounts
import com.example.frontServer.entity.Follow
import com.example.frontServer.entity.QFollow
import com.example.frontServer.entity.QUser
import com.querydsl.core.types.dsl.CaseBuilder
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class FollowQueryDslRepositoryImpl(
    private val queryFactory: JPAQueryFactory
): FollowQueryDslRepository {
    private val follow = QFollow.follow
    private val qUser = QUser.user

    override fun findFollowCounts(targetUserId: Long): FollowCounts {
        val followingCountExpr = CaseBuilder()
            .`when`(follow.followerId.eq(targetUserId))
            .then(1)
            .otherwise(0)
        val followerCountExpr = CaseBuilder()
            .`when`(follow.followingId.eq(targetUserId))
            .then(1)
            .otherwise(0)

        val result = queryFactory
            .select(
                followingCountExpr.sum(),
                followerCountExpr.sum()
            )
            .from(follow)
            .fetchOne()
        return FollowCounts(
            followingCount = result?.get(0, Number::class.java)?.toLong() ?: 0L,
            followerCount = result?.get(1, Number::class.java)?.toLong() ?: 0L
        )
    }

    override fun findFollowersById(targetUserId: Long): List<Follow> {
        return queryFactory
            .selectFrom(follow)
            .where(follow.followingId.eq(targetUserId))
            .fetch()
    }
}