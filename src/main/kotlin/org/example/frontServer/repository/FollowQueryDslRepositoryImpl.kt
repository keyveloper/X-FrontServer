package com.example.frontServer.repository

import com.example.frontServer.entity.QFollow
import com.example.frontServer.entity.QUser
import com.example.frontServer.entity.User
import com.querydsl.jpa.JPAExpressions
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class FollowQueryDslRepositoryImpl(
    private val queryFactory: JPAQueryFactory
): FollowQueryDslRepository {
    private val qFollow = QFollow.follow
    private val qUser = QUser.user
    // following Users
    override fun findFollowersByUsername(username: String): List<User> {
        return queryFactory
            .select(qUser)
            .from(qFollow)
            .where(
                qFollow.followingId.eq(
                    JPAExpressions
                        .select(qUser.id)
                        .where(qUser.username.eq(username)
                        )
                )
            )
            .fetch()
    }

    override fun findFollowingsByUserId(username: String): List<User> {
        return queryFactory
            .select(qUser)
            .from(qFollow)
            .where(
                qFollow.followerId.eq(
                    JPAExpressions
                        .select(qUser.id)
                        .where(qUser.username.eq(username))
                )
            )
            .fetch()
    }
}