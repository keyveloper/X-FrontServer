package com.example.frontServer.repository

import com.example.frontServer.dto.timeline.TimelineSearchPolicy
import com.example.frontServer.entity.QTimeline
import com.example.frontServer.entity.Timeline
import com.querydsl.jpa.impl.JPAQueryFactory
import java.time.LocalDateTime

class TimelineQueryDslRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory
): TimelineQueryDslRepository {
    private val timeline = QTimeline.timeline

    override fun findAllByPolicy(policy: TimelineSearchPolicy): List<Timeline> {
        val threeDaysAgo = policy.currentTime.minusDays(3)

        return jpaQueryFactory
            .selectFrom(timeline)
            .where(
                timeline.receiverId.eq(policy.receiverId)
                    .and(timeline.id.gt(policy.lastSeenId))
                    .and(timeline.createdAt.between(threeDaysAgo, policy.currentTime))
            )
            .orderBy(timeline.createdAt.asc())
            .limit(policy.pageSize)
            .fetch()
    }
}