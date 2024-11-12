package com.example.frontServer.dto.board

import java.time.LocalDateTime

data class BoardResult(
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
        fun of(
            boardWithComment: BoardWithComment,
            writerName: String,
            likeCount: Int,
        ) : BoardResult {
            val board = boardWithComment.board
                return BoardResult(
                    id = board.id!!,
                    writerName = writerName,
                    textContent = board.textContent,
                    fileApiUrl = board.fileApiUrl,
                    createdAt = board.createdAt!!,
                    lastModifiedAt = board.lastModifiedAt!!,
                    readingCount = board.readingCount,
                    commentCount = boardWithComment.getCommentCount(),
                    jsonComment = boardWithComment.jsonComments,
                    likeCount = likeCount
                )
            }
        }
    }