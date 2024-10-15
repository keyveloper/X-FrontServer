package com.example.frontServer.repository

import com.example.frontServer.dto.BoardWithUsernameDto

interface BoardQueryDslRepository {
    fun countRepliesById(id: Long) : Long

    fun findAllWithUsername(): List<BoardWithUsernameDto>

    fun findByIdWithUsername(id: Long): BoardWithUsernameDto?
}