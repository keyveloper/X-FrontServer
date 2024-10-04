package com.example.frontServer.dto

import java.time.LocalDateTime

data class GetAllBoardResponse (
    val id: Long,
    val writer: String,
    val textContent: String,
    val imgUrl: String?,
    val firstWritingDate: LocalDateTime,
    val lastModifiedDate: LocalDateTime,
    val readingCount : Long,
    val likeCount: Long,
    val type: String,
    val commentCount: Long,
) {
    companion object {
        fun of(result : GetAllBoardResult): GetAllBoardResponse {
            return GetAllBoardResponse(
                id = result.id,
                writer = result.writer,
                textContent = result.textContent,
                imgUrl = result.imgUrl,//
                firstWritingDate = result.firstWritingDate,
                lastModifiedDate = result.lastModifiedDate,
                readingCount = result.readingCount,
                likeCount = result.likeCount,
                type = result.type,
                commentCount = result.commentCount,
            )
        }
    }
}