package com.example.frontServer.dto.timeline

import com.example.frontServer.dto.board.BoardResult
import com.example.frontServer.dto.board.BoardWithComment
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

    val jsonComment: String?,

    val likeCount: Int
) {
    companion object {
        fun of(board: BoardWithComment): TimelineBoardResult {
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
                jsonComment = board.jsonComments,
                likeCount = 0
            )
        }
    }
}