package com.example.frontServer.repository

import com.example.frontServer.entity.Board
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BoardRepository: JpaRepository<Board, Long>, BoardQueryDslRepository {
}