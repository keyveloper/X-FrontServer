package com.example.frontServer.repository

import com.example.frontServer.entity.TimelineCursor
import org.springframework.data.jpa.repository.JpaRepository

interface TimelineCursorRepository: JpaRepository<TimelineCursor, Long>{
    fun findByReceiverId(userId: Long): TimelineCursor?
}