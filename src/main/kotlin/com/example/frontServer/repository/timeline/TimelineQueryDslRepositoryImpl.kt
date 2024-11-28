package com.example.frontServer.repository.timeline

import com.example.frontServer.dto.timeline.TimelineRequest
import com.example.frontServer.entity.QTimeline
import com.example.frontServer.entity.Timeline
import com.querydsl.jpa.impl.JPAQueryFactory

class TimelineQueryDslRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory
): TimelineQueryDslRepository {
    private val timeline = QTimeline.timeline

    override fun findAllNextBoardIds(timelineRequest: TimelineRequest): List<Timeline> {
        return jpaQueryFactory
            .selectFrom(timeline)
            .where(timeline.receiverId.eq(timelineRequest.receiverId)
                .and(timeline.id.gt(timelineRequest.endBoardId))
            )
            .orderBy(timeline.createdAt.asc())
            .limit(15)
            .fetch()
    }

    override fun findAllBeforeBoardIds(timelineRequest: TimelineRequest): List<Timeline> {
        return jpaQueryFactory
            .selectFrom(timeline)
            .where(timeline.receiverId.eq(timelineRequest.receiverId)
                .and(timeline.id.lt(timelineRequest.startBoardId))
            )
            .orderBy(timeline.createdAt.asc())
            .limit(15)
            .fetch()
    }
}