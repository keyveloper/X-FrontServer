package com.example.frontServer.dto.board.request

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive

data class CommentGetRequest(

    val parentId: Long,

    @field:Positive(message = "commentId should be positive")
    val endCommentId: Long // scrolling
)