package com.example.frontServer.repository.timeline

import com.example.frontServer.dto.timeline.TimelineRequest
import com.example.frontServer.entity.Timeline

interface TimelineQueryDslRepository {
    fun findAllNextBoardIds(timelineRequest: TimelineRequest): List<Timeline>

    fun findAllBeforeBoardIds(timelineRequest: TimelineRequest): List<Timeline>
}