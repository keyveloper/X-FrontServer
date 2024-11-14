package com.example.frontServer.repository

import com.example.frontServer.dto.board.BoardWithComment
import com.example.frontServer.entity.QBoard
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import com.querydsl.core.types.dsl.Expressions


@Repository
class BoardQueryDslRepositoryImpl(
    val queryFactory: JPAQueryFactory
): BoardQueryDslRepository {
    private val board = QBoard.board
    val comment = QBoard("comment") // 같은 테이블에 대해 두 번째 별칭 생성

    //
    override fun findAllBoardWithComment(): List<BoardWithComment> {
        val jsonComments = Expressions.stringTemplate(
            "JSON_ARRAYAGG(JSON_OBJECT('id', {0}.id, 'writer_id', {0}.writer_id, " +
                    "'text_content', {0}.text_content, " + "'file_api_url', {0}.file_api_url, " +
                    "'created_at', {0}.created_at, 'last_modified_at', {0}.last_modified_at, " +
                    "'reading_count', {0}.reading_count, 'invalid', {0}.invalid))",
            comment
        )

        return queryFactory
            .select(
                board,
                jsonComments.`as`("comments")
            )
            .from(board)
            .leftJoin(comment).on(comment.parentId.eq(board.id))
            .where(board.parentId.isNull
                .and(board.invalid.eq(false)))
            .groupBy(board.id)
            .fetch()
            .map {tuple ->
                BoardWithComment(
                    board = tuple.get(board)!!,
                    jsonComments = tuple.get(jsonComments)?: "[]"
                )
            }
    }

    override fun findAllBoardWithCommentByIds(ids: List<Long>): List<BoardWithComment> {
        val jsonComments = Expressions.stringTemplate(
            "JSON_ARRAYAGG(JSON_OBJECT('id', {0}.id, 'writer_id', {0}.writer_id, " +
                    "'text_content', {0}.text_content, " + "'file_api_url', {0}.file_api_url, " +
                    "'created_at', {0}.created_at, 'last_modified_at', {0}.last_modified_at, " +
                    "'reading_count', {0}.reading_count, 'invalid', {0}.invalid))",
            comment
        )

        return queryFactory
            .select(
                board,
                jsonComments.`as`("comments")
            )
            .from(board)
            .leftJoin(comment).on(comment.parentId.eq(board.id))
            .where(board.parentId.isNull
                .and(board.invalid.eq(false))
                .and(board.id.`in`(ids)))
            .groupBy(board.id)
            .fetch()
            .map {tuple ->
                BoardWithComment(
                    board = tuple.get(board)!!,
                    jsonComments = tuple.get(jsonComments)?: "[]"
                )
            }
    }

    override fun findBoardWithCommentById(boardId: Long): BoardWithComment? {
        val jsonComments = Expressions.stringTemplate(
            "JSON_ARRAYAGG(JSON_OBJECT('id', {0}.id, 'writer_id', {0}.writer_id, " +
                    "'text_content', {0}.text_content, " + "'file_api_url', {0}.file_api_url, " +
                    "'created_at', {0}.created_at, 'last_modified_at', {0}.last_modified_at, " +
                    "'reading_count', {0}.reading_count, 'invalid', {0}.invalid))",
            comment
        )

        val tuple = queryFactory
            .select(
                board,
                jsonComments.`as`("comments")
            )
            .from(board)
            .leftJoin(comment).on(comment.parentId.eq(boardId))
            .where(board.id.eq(boardId)
                .and(board.invalid.eq(false)))
            .groupBy(board.id)
            .fetchOne()

        return tuple?.let {
            BoardWithComment(
                board = it.get(board)!!,
                jsonComments = it.get(jsonComments)?: "[]"
            )
        }
    }
}