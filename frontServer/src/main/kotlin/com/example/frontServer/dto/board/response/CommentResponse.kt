package com.example.frontServer.dto.board.response

data class CommentResponse(
    val results: List<CommentResult>
) {
    companion object {
        fun of(results: List<CommentResult>): CommentResponse {
            return CommentResponse(
                results
            )
        }
    }
}