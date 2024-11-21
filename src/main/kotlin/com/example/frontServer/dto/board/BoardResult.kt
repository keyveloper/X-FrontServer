package com.example.frontServer.dto.board

import com.example.frontServer.entity.Board
import java.time.LocalDateTime

data class BoardResult(
    val id: Long,

    val writerName: String,

    val textContent: String,

    val fileApiUrl: String?,

    val createdAt: LocalDateTime,

    val lastModifiedAt: LocalDateTime,

    val readingCount: Long,

    val commentCount: Int,

    val comments: List<BoardCommentResult>,

    val likeCount: Int
) {
    companion object {
        fun of(
            board: Board,
            commentCount: Int,
            writerName: String,
            likeCount: Int,
            boardCommentResult: List<BoardCommentResult>
        ) : BoardResult {
            return BoardResult(
                id = board.id!!,
                writerName = writerName,
                textContent = board.textContent,
                fileApiUrl = board.fileApiUrl,
                createdAt = board.createdAt!!,
                lastModifiedAt = board.lastModifiedAt!!,
                readingCount = board.readingCount,
                commentCount = commentCount,
                comments = boardCommentResult,
                likeCount = likeCount
                )
            }
        }
    }