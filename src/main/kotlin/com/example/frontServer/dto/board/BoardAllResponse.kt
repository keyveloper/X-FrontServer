package com.example.frontServer.dto.board

import com.example.frontServer.dto.ErrorResponse
import com.example.frontServer.enum.FrontServerError

data class BoardAllResponse(
    val boardAllResults: List<BoardAllResult>,
): ErrorResponse(FrontServerError.OK, null) {
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