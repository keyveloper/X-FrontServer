package com.example.frontServer.dto.timeline.response

import com.example.frontServer.dto.board.BoardWithCommentCount
import java.time.LocalDateTime

data class TimelineBoardResult(
    val id: Long,

    val writerName: String,

    val textContent: String,

    val fileApiUrl: String?,

    val createdAt: LocalDateTime,

    val lastModifiedAt: LocalDateTime,

    val readingCount: Long,

    val commentCount:Long,

    val likeCount: Long
) {
    companion object {
        fun of(
            boardWithComment: BoardWithCommentCount,
            writerName: String,
            likeCount: Long
            ): TimelineBoardResult {
            val board = boardWithComment.board
            return TimelineBoardResult(
                id = board.id!!,
                writerName = writerName,
                textContent = board.textContent,
                fileApiUrl = board.fileApiUrl,
                createdAt = board.createdAt!!,
                lastModifiedAt = board.lastModifiedAt!!,
                readingCount = board.readingCount,
                commentCount = boardWithComment.commentCount,
                likeCount = likeCount
            )
        }
    }
}