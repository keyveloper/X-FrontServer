package com.example.frontServer.dto.like.response

data class LikeChangeResult(
    val targetBoardId: Long?,
    val likeType: Int?,
) {
    companion object {
        fun of(serverResult: LikeServerChangeResult): LikeChangeResult {
            return LikeChangeResult(
                targetBoardId = serverResult.boardId,
                likeType = serverResult.changedType
            )
        }
    }
}