package com.example.frontServer.dto.board.response

data class SingleBoardResponse(
    val result: SingleBoardResult,
) {
    companion object {
        fun of(result: SingleBoardResult): SingleBoardResponse {
            return SingleBoardResponse(result)
        }
    }
}