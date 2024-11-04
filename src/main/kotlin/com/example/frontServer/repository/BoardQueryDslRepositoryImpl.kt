package com.example.frontServer.repository

import com.example.frontServer.dto.BoardInfo
import com.example.frontServer.entity.QBoard
import com.example.frontServer.entity.QUser
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class BoardQueryDslRepositoryImpl(
    val queryFactory: JPAQueryFactory
): BoardQueryDslRepository {
    private val board = QBoard.board
    private val user = QUser.user

    override fun findAllWithUsername(): List<BoardInfo> {
        return queryFactory
            .select(
                board, user.username,
            )
            .from(board)
            .join(user).on(board.writerId.eq(user.id))
            .fetch()
            .map { tuple ->
                BoardInfo(
                    board = tuple.get(board)!!,
                    username = tuple.get(user.username)!!
                )
            }
    }

    // replies 같이
    override fun findByIdWithUsername(id: Long): BoardInfo? {
        return queryFactory
            .select(board, user.username)
            .from(board)
            .join(user).on(board.writerId.eq(user.id))
            .where(board.id.eq(id))
            .fetchOne()
            ?.let {
                BoardInfo(
                    board = it.get(board)!!,
                    username = it.get(user.username)!!
                )
            }
    }

    override fun findByIdsWithUsername(ids: List<Long>): List<BoardInfo> {
        return queryFactory
            .select(board, user.username)
            .from(board)
            .join(user).on(board.writerId.eq(user.id))
            .where(board.id.`in`(ids))
            .fetch()
            .map { tuple ->
                BoardInfo(
                    board = tuple.get(board)!!,
                    username = tuple.get(user.username)!!
                )
            }
    }

    override fun findRepliesByParentId(parentId: Long): List<BoardInfo> {
        return queryFactory
            .select(board, user.username)
            .join(user).on(board.writerId.eq(user.id))
            .where(board.parentId.eq(parentId))
            .fetch()
            .map { tuple ->
                BoardInfo(
                    board = tuple.get(board)!!,
                    username = tuple.get(user.username)!!
                )
            }
    }

    override fun countRepliesById(id: Long): Long {
        return queryFactory
            .select(board.count())
            .from(board)
            .where(board.parentId.eq(id))
            .fetchOne() ?: 0L
    }
}