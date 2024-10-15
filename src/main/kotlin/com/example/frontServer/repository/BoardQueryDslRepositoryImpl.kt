package com.example.frontServer.repository

import com.example.frontServer.dto.BoardWithUsernameDto
import com.example.frontServer.entity.QBoard
import com.example.frontServer.entity.QUser
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class BoardQueryDslRepositoryImpl(
    val queryFactory: JPAQueryFactory
): BoardQueryDslRepository {
    private val qBoard = QBoard.board
    private val qUser = QUser.user

    override fun countRepliesById(id: Long) : Long {
        return queryFactory
            .select(qBoard.count())
            .from(qBoard)
            .where(qBoard.parentId.eq(id))
            .fetchOne() ?: 0L
    }

    override fun findAllWithUsername(): List<BoardWithUsernameDto> {
        return queryFactory
            .select(
                qBoard,
                qUser.username
            )
            .from(qBoard)
            .join(qUser).on(qBoard.writer.eq(qUser.id))
            .fetch()
            .map { tuple ->
                BoardWithUsernameDto(
                    board = tuple.get(qBoard)!!,
                    username = tuple.get(qUser.username)!!
                )
            }
    }

    override fun findByIdWithUsername(id: Long): BoardWithUsernameDto? {
        return queryFactory
            .select(
                qBoard,
                qUser.username
            )
            .from(qBoard)
            .join(qUser).on(qBoard.writer.eq(qUser.id))
            .where(qBoard.id.eq(id))
            .fetchOne()
            ?.let{ tuple ->
                val board = tuple.get(qBoard)
                val username = tuple.get(qUser.username)
                if (board != null && username != null) {
                    BoardWithUsernameDto(
                        board = board,          // BoardEntity 값 가져오기
                        username = username // username 값 가져오기
                    )
                } else {
                    return null
                }
            }
    }

}