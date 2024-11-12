package com.example.frontServer.repository

import com.example.frontServer.dto.board.BoardWithComment

interface BoardQueryDslRepository {
    fun findAllBoardWithComment(): List<BoardWithComment>

    fun findBoardWithCommentById(boardId: Long): BoardWithComment?
}