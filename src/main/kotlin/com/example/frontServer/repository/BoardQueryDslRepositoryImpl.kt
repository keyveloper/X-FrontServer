package com.example.frontServer.repository

import com.example.frontServer.dto.board.BoardWithComment
import com.example.frontServer.dto.board.BoardWithCommentCount
import com.example.frontServer.entity.QBoard
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository


@Repository
class BoardQueryDslRepositoryImpl(
    val queryFactory: JPAQueryFactory
): BoardQueryDslRepository {
    private val board = QBoard.board
    val comment = QBoard("comment") // 같은 테이블에 대해 두 번째 별칭 생성

    //
    override fun findAllWithCommentCount() : List<BoardWithCommentCount> {
        return queryFactory
            .select(
                board,
                comment.count().`as`("commentCount")
            )
            .from(board)
            .leftJoin(comment).on(comment.parentId.eq(board.id))
            .where(board.invalid.eq(false)
            )
            .fetch()
            .map { tuple ->
                BoardWithCommentCount(
                    board = tuple.get(board)!!,
                    commentCount = tuple.get(1, Long::class.java) ?: 0L
                )
            }

    }

    override fun findAllWithCommentCountByIds(ids: List<Long>): List<BoardWithCommentCount> {
        return queryFactory
            .select(
                board,
                comment.count().`as`("commentCount")
            )
            .from(board)
            .leftJoin(comment).on(comment.parentId.eq(board.id))
            .where(board.id.`in`(ids)
                .and(board.invalid.eq(false)
                    .and(board.parentId.isNull))
            )
            .groupBy(board.id)
            .fetch()
            .map { tuple ->
                BoardWithCommentCount(
                    board = tuple.get(board)!!,
                    commentCount = tuple.get(1, Long::class.java) ?: 0L
                )
            }

    }


    override fun findBoardWithCommentById(boardId: Long): BoardWithComment? {
        val result = queryFactory
            .select(
                board,
                comment
            )
            .from(board)
            .leftJoin(comment).on(comment.parentId.eq(boardId))
            .where(board.id.eq(boardId)
                .and(board.invalid.eq(false)))
            .groupBy(board.id)
            .fetch()

        if (result.isEmpty()) {
            return null
        }

        val boardEntity = result[0].get(board)
        val comments = result.mapNotNull { it.get(comment) }

        return BoardWithComment(
            board = boardEntity!!,
            comments = comments
        )
    }
}