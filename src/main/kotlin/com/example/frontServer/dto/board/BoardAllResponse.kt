package com.example.frontServer.dto.board

class BoardAllResponse(
    val boardAllResults: List<BoardAllResult>,
) {
    companion object {
        fun of(
            boardAllResults: List<BoardAllResult>,
        ) : BoardAllResponse {
            return BoardAllResponse(
                boardAllResults = boardAllResults,
            )
        }
    }
}