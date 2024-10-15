package com.example.frontServer.dto

import com.example.frontServer.entity.Board
import java.time.LocalDateTime

class GetBoardResult (
    val id: Long,
    val writer: String,
    val textContent: String,
    val fileApiUrl: String?,
    val firstWritingDate: LocalDateTime,
    val lastModifiedDate: LocalDateTime,
    val readingCount : Long,
) {

    companion object {
        fun of(boardDto: BoardWithUsernameDto): GetBoardResult {
            return GetBoardResult(//
                id = boardDto.board.id!!,
                writer = boardDto.username,
                textContent = boardDto.board.textContent,
                fileApiUrl = boardDto.board.fileApiUri,
                firstWritingDate = boardDto.board.firstWritingDate!!,
                lastModifiedDate = boardDto.board.lastModifiedDate!!,
                readingCount = boardDto.board.readingCount,
            )
        }
    }
}
