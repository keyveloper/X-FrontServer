package com.example.frontServer.dto.timeline.response

import com.example.frontServer.dto.board.BoardWithCommentCount
import java.time.LocalDateTime

data class TimelineBoardGetResult(
    val id: Long,

    val userId: Long,

    val username: String,

    // profile image needed1!
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
            ): TimelineBoardGetResult {
            val board = boardWithComment.board
            return TimelineBoardGetResult(
                id = board.id!!,
                userId = board.writerId,
                username = writerName,
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