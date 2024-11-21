package com.example.frontServer.repository

import com.example.frontServer.entity.TimelineCursor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.jpa.repository.Modifying


interface TimelineCursorRepository: JpaRepository<TimelineCursor, Long>{
    fun findByReceiverId(userId: Long): TimelineCursor?

    @Modifying
    @Query("update TimelineCursor t SET t.lastSeenId = :lastSeenId where t.receiverId = :receiverId")
    fun updateLastSeenId(receiverId: Long, lastSeenId: Long): Int
}