package com.example.frontServer.dto.board

import com.example.frontServer.dto.ErrorResponse
import com.example.frontServer.enum.FrontServerError

class BoardResponse(
    val boardResult: BoardResult?,
    ){
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