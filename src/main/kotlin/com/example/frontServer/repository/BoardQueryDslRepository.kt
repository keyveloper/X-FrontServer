package com.example.frontServer.repository

import com.example.frontServer.dto.board.BoardWithComment
import com.example.frontServer.dto.board.BoardWithUsernameAndComment

interface BoardQueryDslRepository {
    fun findAllBoardWithComment(): List<BoardWithComment>

    fun findBoardWithCommentById(boardId: Long): BoardWithComment?
}