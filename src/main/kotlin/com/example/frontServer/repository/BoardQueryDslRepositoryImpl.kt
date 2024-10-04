package com.example.frontServer.repository

import com.example.frontServer.entity.QBoard
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class BoardQueryDslRepositoryImpl(
    val queryFactory: JPAQueryFactory
): BoardQueryDslRepository {
    private val qBoard = QBoard.board
    override fun countRepliesById(id: Long) : Long {
        return queryFactory
            .select(qBoard.count())
            .from(qBoard)
            .where(qBoard.parentId.eq(id))
            .fetchOne() ?: 0L
    }
}