package com.example.frontServer.repository.board

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


    override fun findInitComment(parentId: Long): List<BoardWithCommentCount> {
        return queryFactory
            .select(
                board,
                comment.count().`as`("commentCount")
            )
            .from(board)
            .leftJoin(comment).on(comment.parentId.eq(parentId))
            .where(board.invalid.eq(false))
            .limit(11)
            .orderBy(board.lastModifiedAt.desc())
            .fetch()
            .map { tuple ->
                BoardWithCommentCount(
                    board = tuple.get(board)!!,
                    commentCount = tuple.get(1, Long::class.java) ?: 0L
                )
            }
    }

    override fun findNextComment(parentId: Long, endBoardId: Long): List<BoardWithCommentCount> {
        return queryFactory
                .select(
            board,
            comment.count().`as`("commentCount")
        )
            .from(board)
            .leftJoin(comment).on(comment.parentId.eq(parentId))
            .where(board.invalid.eq(false)
                .and(board.id.gt(endBoardId)))
            .limit(11)
            .orderBy(board.lastModifiedAt.desc())
            .fetch()
            .map { tuple ->
                BoardWithCommentCount(
                    board = tuple.get(board)!!,
                    commentCount = tuple.get(1, Long::class.java) ?: 0L
                )
            }
    }


    override fun findTimelineByBoardIds(ids: List<Long>): List<BoardWithCommentCount> {
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
}