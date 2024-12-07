package com.example.frontServer.dto.board

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