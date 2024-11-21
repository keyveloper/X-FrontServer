package com.example.frontServer.repository

import com.example.frontServer.dto.board.BoardWithComment
import com.example.frontServer.dto.board.BoardWithCommentCount

interface BoardQueryDslRepository {
    fun findAllWithCommentCount() : List<BoardWithCommentCount>
    fun findAllWithCommentCountByIds(ids: List<Long>): List<BoardWithCommentCount>
    fun findBoardWithCommentById(boardId: Long): BoardWithComment?
}