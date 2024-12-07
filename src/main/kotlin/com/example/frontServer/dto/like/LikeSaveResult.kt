package com.example.frontServer.dto.like

import com.example.frontServer.enum.FrontServerCode
import com.example.frontServer.enum.ServiceServerError

// service to controller
data class LikeSaveResult(
    val error: FrontServerCode?
) {
    companion object {
        fun of(serverResult: LikeServerSaveResponse): LikeSaveResult {
            if (serverResult.error == null) {
                return LikeSaveResult(null)
            }

            return if (serverResult.error == ServiceServerError.UNKNOWN_ID) {
                LikeSaveResult(
                    error = FrontServerCode.INVALID_ID
                )
            } else {
                LikeSaveResult(
                    error = FrontServerCode.OK // need change!!!
                )
            }
        }
    }
}