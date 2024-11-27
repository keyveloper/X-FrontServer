package com.example.frontServer.dto.like

import com.example.frontServer.enum.FrontServerError
import com.example.frontServer.enum.ServiceServerError

// service to controller
data class LikeSaveResult(
    val error: FrontServerError?
) {
    companion object {
        fun of(serverResult: LikeServerSaveResponse): LikeSaveResult {
            if (serverResult.error == null) {
                return LikeSaveResult(null)
            }

            return if (serverResult.error == ServiceServerError.UNKNOWN_ID) {
                LikeSaveResult(
                    error = FrontServerError.INVALID_ID
                )
            } else {
                LikeSaveResult(
                    error = FrontServerError.OK // need change!!!
                )
            }
        }
    }
}