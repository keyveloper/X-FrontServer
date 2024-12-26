package com.example.frontServer.repository.follow

import com.example.frontServer.dto.follow.FollowCounts
import com.example.frontServer.entity.QFollow
import com.example.frontServer.entity.QUser
import com.example.frontServer.entity.User
import com.querydsl.core.types.dsl.CaseBuilder
import com.querydsl.jpa.JPAExpressions
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class FollowQueryDslRepositoryImpl(
    private val queryFactory: JPAQueryFactory
): FollowQueryDslRepository {
    private val follow = QFollow.follow
    private val qUser = QUser.user

    override fun findFollowCount(targetUserId: Long): FollowCounts {
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
            followingCount = result?.get(0, Long::class.java) ?: 0L,
            followerCount = result?.get(1, Long::class.java) ?: 0L
        )
    }

    // following Users
    override fun findFollowersByUsername(username: String): List<User> {
        return queryFactory
            .selectFrom(qUser)
            .where(
                qUser.id.`in` (
                        JPAExpressions
                            .select(follow.followerId)
                            .from(follow)
                            .where(
                                follow.followingId.eq(
                                    JPAExpressions
                                        .select(qUser.id)
                                        .from(qUser)
                                        .where(qUser.username.eq(username))
                                )
                            )
                        )
            )
            .fetch()
    }

    override fun findFollowingsByUserId(username: String): List<User> {
        return queryFactory
            .selectFrom(qUser)
            .where(
                qUser.id.`in` (
                    JPAExpressions
                        .select(follow.followingId)
                        .from(follow)
                        .where(follow.followerId.eq(
                            JPAExpressions
                                .select(qUser.id)
                                .from(qUser)
                                .where(qUser.username.eq(username))
                        ))
                )
            )
            .fetch()
    }
}