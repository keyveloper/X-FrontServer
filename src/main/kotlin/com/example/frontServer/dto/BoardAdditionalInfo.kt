package com.example.frontServer.dto

import com.example.frontServer.entity.Board

data class BoardAdditionalInfo(
    val board: Board,
    val username: String,
    val likeCount: Long,
    val replyCount: Long,
) {
    companion object {
        fun of(boardInfo: BoardInfo, likeCount: Long, replyCount: Long): BoardAdditionalInfo {
            return BoardAdditionalInfo(
                board = boardInfo.board,
                username = boardInfo.username,
                likeCount = likeCount,
                replyCount = replyCount,
            )
        }
    }
}
