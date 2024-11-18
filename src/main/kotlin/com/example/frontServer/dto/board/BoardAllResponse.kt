package com.example.frontServer.dto.board

import com.example.frontServer.dto.ErrorResponse

data class BoardAllResponse(
    val boardResults: List<BoardResult>,
    val errorResponse: ErrorResponse?
) {
    companion object {
        fun of(
            boardResults: List<BoardResult>,
            errorResponse: ErrorResponse?
        ) : BoardAllResponse {
            return BoardAllResponse(
                boardResults = boardResults,
                errorResponse = errorResponse
            )
        }
    }
}