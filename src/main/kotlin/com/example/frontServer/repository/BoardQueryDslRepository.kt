package com.example.frontServer.repository

import com.example.frontServer.dto.BoardInfo
import com.querydsl.core.Tuple

interface BoardQueryDslRepository {
    fun findAllWithUsername(): List<BoardInfo>

    fun findByIdWithUsername(id: Long): BoardInfo?

    fun findByIdsWithUsername(id: List<Long>): List<BoardInfo>

    fun findRepliesByParentId(parentId: Long): List<BoardInfo>

    fun countRepliesById(id: Long): Long
}