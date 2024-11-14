package com.example.frontServer.dto.board

import com.example.frontServer.dto.ErrorResponse

data class BoardResponse(
    val boardResult: BoardResult?,
    val errorResponse: ErrorResponse?
    ) {
    companion object {
        fun of(
            boardResult: BoardResult?,
            errorResponse: ErrorResponse?
        ) : BoardResponse {
            return BoardResponse(
                boardResult = boardResult,
                errorResponse = errorResponse
            )
        }
    }
}