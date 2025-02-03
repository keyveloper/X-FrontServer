package com.example.frontServer.dto.like.response

data class LikeSaveResult(
    val saveLikeId: Long?,
    val targetBoardId: Long?
) {
    companion object {
        fun of(serverResult: LikeServerSaveResult): LikeSaveResult {
            return LikeSaveResult(
                saveLikeId = serverResult.id,
                targetBoardId = serverResult.targetBoardId
            )
        }
    }
}
