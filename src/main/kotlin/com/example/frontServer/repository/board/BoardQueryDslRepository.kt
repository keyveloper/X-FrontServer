package com.example.frontServer.repository.board

import com.example.frontServer.dto.board.BoardWithComments
import com.example.frontServer.dto.board.BoardWithCommentCount

interface BoardQueryDslRepository {
    fun findInitComment(parentId: Long): List<BoardWithCommentCount>
    fun findNextComment(parentId: Long, endBoardId: Long): List<BoardWithCommentCount>
    fun findTimelineByBoardIds(ids: List<Long>): List<BoardWithCommentCount>
}