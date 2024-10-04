package com.example.frontServer.dto

import java.time.LocalDateTime

data class GetBoardResponse (
    val id: Long,
    val writer: String,
    val textContent: String,
    val imgUrl: String?,
    val firstWritingDate: LocalDateTime,
    val lastModifiedDate: LocalDateTime,
    val readingCount : Long,
    val likeCount: Long,
    val type: String,
) {//

    companion object {
        fun of(result: GetBoardResult): GetBoardResponse{
            return GetBoardResponse(
                id = result.id,
                writer = result.writer,
                textContent = result.textContent,
                imgUrl = result.imgUrl,
                firstWritingDate = result.firstWritingDate,
                lastModifiedDate = result.lastModifiedDate,
                readingCount = result.readingCount,
                likeCount = result.likeCount,
                type = result.type
            )
        }
    }
}