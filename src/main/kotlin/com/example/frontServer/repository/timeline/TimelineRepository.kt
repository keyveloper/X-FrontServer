package com.example.frontServer.repository.timeline

import com.example.frontServer.entity.Timeline
import org.springframework.data.jpa.repository.JpaRepository

interface TimelineRepository: JpaRepository<Timeline, Long>, TimelineQueryDslRepository {
    fun findAllBoardIdByReceiverId(receiverId: Long): List<Long>
}