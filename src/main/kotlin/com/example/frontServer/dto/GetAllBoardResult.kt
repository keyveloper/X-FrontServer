package com.example.frontServer.dto

import com.example.frontServer.entity.Board
import java.time.LocalDateTime

class GetAllBoardResult(
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
        fun of(board: Board, commentCount: Long): GetAllBoardResult {
            return GetAllBoardResult(
                id = board.id!!,
                writer = board.writer!!.username,
                textContent = board.textContent,
                imgUrl = board.imgUri,
                firstWritingDate = board.firstWritingDate!!,
                lastModifiedDate = board.lastModifiedDate!!,
                readingCount = board.readingCount,
                likeCount = board.likeCount,
                type = board.type.toString(),
                commentCount = commentCount
            )
        }
    }
}

