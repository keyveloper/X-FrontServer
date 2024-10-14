package com.example.frontServer.dto

import com.example.frontServer.entity.Board
import java.time.LocalDateTime

class GetAllBoardResult(
    val id: Long,
    val writer: Long,
    val textContent: String,
    val fileApiUrl: String?,
    val firstWritingDate: LocalDateTime,
    val lastModifiedDate: LocalDateTime,
    val readingCount : Long,
    val commentCount: Long,
) {
    companion object {
        fun of(board: Board, commentCount: Long): GetAllBoardResult {
            return GetAllBoardResult(
                id = board.id!!,
                writer = board.writer,
                textContent = board.textContent,
                fileApiUrl = board.fileApiUri,
                firstWritingDate = board.firstWritingDate!!,
                lastModifiedDate = board.lastModifiedDate!!,
                readingCount = board.readingCount,
                commentCount = commentCount
            )
            // like count should be added
        }
    }
}

