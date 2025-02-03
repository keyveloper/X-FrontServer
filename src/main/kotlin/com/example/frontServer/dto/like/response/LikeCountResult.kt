package com.example.frontServer.dto.like.response

data class LikeCountResult(
    val targetBoardId: Long,
    val totalCount: Long
) {
    companion object {
        fun of(
            serverResult: LikeServerCountResult
        ): LikeCountResult {
            return LikeCountResult(
                targetBoardId = serverResult.targetBoardId,
                totalCount = serverResult.totalCount
            )
        }
    }
}
