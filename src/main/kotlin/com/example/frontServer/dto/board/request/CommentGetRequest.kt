package com.example.frontServer.dto.board.request

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive

data class CommentGetRequest(

    @filed:NotNull(message = "parentId is required")
    val parentId: Long,

    @field:NotNull(message = "endCommentId is required")
    @field:Positive(message = "commentId should be positive")
    val endCommentId: Long // scrolling
)