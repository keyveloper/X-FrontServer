package com.example.frontServer.dto.board

import com.example.frontServer.dto.ErrorResponse
import com.example.frontServer.enum.FrontServerError

data class BoardResponse(
    val boardResult: BoardResult?,
    ): ErrorResponse(FrontServerError.OK, null){
    companion object {
        fun of(
            boardResult: BoardResult?,
        ) : BoardResponse {
            return BoardResponse(
                boardResult = boardResult,
            )
        }
    }
}