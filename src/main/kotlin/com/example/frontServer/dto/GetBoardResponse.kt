package com.example.frontServer.dto

import java.time.LocalDateTime

data class GetBoardResponse (
    val id: Long,
    val writer: String,
    val textContent: String,
    val fileApiUrl: String?,
    val firstWritingDate: LocalDateTime,
    val lastModifiedDate: LocalDateTime,
    val readingCount : Long,
) {//

    companion object {
        fun of(result: GetBoardResult): GetBoardResponse{
            return GetBoardResponse(
                id = result.id,
                writer = result.writer,
                textContent = result.textContent,
                fileApiUrl = result.fileApiUrl,
                firstWritingDate = result.firstWritingDate,
                lastModifiedDate = result.lastModifiedDate,
                readingCount = result.readingCount,
            )
        }
    }
}