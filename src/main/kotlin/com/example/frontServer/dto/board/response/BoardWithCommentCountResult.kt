package com.example.frontServer.dto.board.response

import java.time.LocalDateTime

data class BoardWithCommentCountResult(
    val id: Long,

    val writerName: String,

    val textContent: String,

    val fileApiUrl: String?,

    val createdAt: LocalDateTime,

    val lastModifiedAt: LocalDateTime,

    val readingCount: Long,

    val commentCount: Int,

    val likeCount: Int
) {

}