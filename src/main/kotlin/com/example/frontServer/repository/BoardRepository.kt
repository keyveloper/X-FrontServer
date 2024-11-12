package com.example.frontServer.repository

import com.example.frontServer.entity.Board
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface BoardRepository: JpaRepository<Board, Long>, BoardQueryDslRepository {
    @Modifying
    @Transactional
    @Query("UPDATE Board b SET b.invalid = TRUE where b.id = :id")
    fun deleteBoardById(@Param("id") id: Long): Int // 수정된 행 갯수 반환
    // 예외 : 존재하지 않는 id, 이미 true인 경우, 트랜잯션오류 -> 둘다 0을 발생
}