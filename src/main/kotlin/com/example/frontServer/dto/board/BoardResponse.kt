package com.example.frontServer.dto.board

import java.time.LocalDateTime
import kotlin.math.ceil

data class BoardResponse(
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
        fun of(boardResult: BoardResult) : BoardResponse {
            return BoardResponse(
                id = boardResult.id,
                writerName = boardResult.writerName,
                textContent = boardResult.textContent,
                fileApiUrl = boardResult.fileApiUrl,
                createdAt = boardResult.createdAt,
                lastModifiedAt = boardResult.lastModifiedAt,
                readingCount = boardResult.readingCount,
                commentCount = boardResult.commentCount,
                jsonComment = boardResult.jsonComment,
                likeCount = boardResult.likeCount
            )
        }
    }
}