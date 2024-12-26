package com.example.frontServer.dto.board.response

import com.example.frontServer.dto.board.BoardWithCommentCount
import java.time.LocalDateTime

data class CommentResult(
    val id: Long,

    val writerName: String,

    val textContent: String,

    val fileApiUrl: String?,

    val createdAt: LocalDateTime,

    val lastModifiedAt: LocalDateTime,

    val readingCount: Long,

    val commentCount: Long,

    val likeCount: Long
) {
    companion object {
        fun of(
            boardWithCommentCount: BoardWithCommentCount,
            writerName: String,
            likeCount: Int
        ): CommentResult {
            return CommentResult(
                id = boardWithCommentCount.board.id!!,
                writerName = writerName,
                likeCount = likeCount,
                createdAt = boardWithCommentCount.board.createdAt!!,
                lastModifiedAt = boardWithCommentCount.board.lastModifiedAt!!,
                readingCount = boardWithCommentCount.board.readingCount,
                commentCount = boardWithCommentCount.commentCount,
                fileApiUrl = boardWithCommentCount.board.fileApiUrl,
                textContent = boardWithCommentCount.board.textContent,
            )
        }
    }
}