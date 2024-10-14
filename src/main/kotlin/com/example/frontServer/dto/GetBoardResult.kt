package com.example.frontServer.dto

import com.example.frontServer.entity.Board
import java.time.LocalDateTime

class GetBoardResult (
    val id: Long,
    val writer: Long,
    val textContent: String,
    val imgUrl: String?,
    val firstWritingDate: LocalDateTime,
    val lastModifiedDate: LocalDateTime,
    val readingCount : Long,
    val likeCount: Long,
    val type: String,
) {

    companion object {
        fun of(board: Board): GetBoardResult {
            return GetBoardResult(//
                id = board.id!!,
                writer = board.writer,
                textContent = board.textContent,
                imgUrl = board.imgUri,
                firstWritingDate = board.firstWritingDate!!,
                lastModifiedDate = board.lastModifiedDate!!,
                readingCount = board.readingCount,
                likeCount = board.likeCount,
                type = board.type.toString()
            )
        }
    }
}
