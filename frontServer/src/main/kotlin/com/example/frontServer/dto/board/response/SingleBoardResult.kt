package com.example.frontServer.dto.board.response

import com.example.frontServer.entity.Board
import java.time.LocalDateTime

data class SingleBoardResult(
    val id: Long,

    val writerName: String,

    val textContent: String,

    val fileApiUrl: String?,

    val createdAt: LocalDateTime,

    val lastModifiedAt: LocalDateTime,

    val readingCount: Long,

    val likeCount: Long
) {
    companion object {
        fun of(board: Board, likeCount: Long, writerName: String): SingleBoardResult {
            return SingleBoardResult(
                id = board.id!!,
                writerName = writerName,
                textContent = board.textContent,
                fileApiUrl = board.fileApiUrl,
                createdAt = board.createdAt!!,
                lastModifiedAt = board.lastModifiedAt!!,
                readingCount = board.readingCount,
                likeCount = likeCount
            )
        }
    }
}