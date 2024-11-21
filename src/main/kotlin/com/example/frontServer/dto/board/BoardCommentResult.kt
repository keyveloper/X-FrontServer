package com.example.frontServer.dto.board

import com.example.frontServer.entity.Board
import java.time.LocalDateTime

data class BoardCommentResult(
    val id: Long,

    val writerName: String,

    val textContent: String,

    val fileApiUrl: String?,

    val createdAt: LocalDateTime,

    val lastModifiedAt: LocalDateTime,

    val readingCount: Long,

    val likeCount: Int
) {
    companion object {
        fun of(
            board: Board,
            writerName: String,
            likeCount: Int,
            ): BoardCommentResult {
            return BoardCommentResult(
                id = board.id!!,
                writerName = writerName,
                textContent = board.textContent,
                fileApiUrl = board.fileApiUrl,
                lastModifiedAt = board.lastModifiedAt!!,
                createdAt = board.createdAt!!,
                readingCount = board.readingCount,
                likeCount = likeCount,
            )
        }
    }
}