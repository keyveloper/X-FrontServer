package com.example.frontServer.dto.timeline

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

    val commentCount:Int,

    val likeCount: Int
) {
    companion object {
        fun of(board: BoardWithCommentCount): TimelineBoardResult {
            val boardResult = board.board
            return TimelineBoardResult(
                id = boardResult.id!!,
                writerName = "",
                textContent = boardResult.textContent,
                fileApiUrl = boardResult.fileApiUrl,
                createdAt = boardResult.createdAt!!,
                lastModifiedAt = boardResult.lastModifiedAt!!,
                readingCount = boardResult.readingCount,
                commentCount = 0,
                likeCount = 0
            )
        }
    }
}