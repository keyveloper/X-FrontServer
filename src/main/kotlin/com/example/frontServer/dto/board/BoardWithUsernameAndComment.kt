package com.example.frontServer.dto.board

data class BoardWithUsernameAndComment(
    val boardWithUsername: BoardWithCommentCount,
    val comments: List<BoardWithCommentCount>
    )

