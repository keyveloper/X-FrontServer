package com.example.frontServer.controller

import com.example.frontServer.dto.ResponseToClientDto
import com.example.frontServer.enum.ResponseCode
import com.example.frontServer.exception.FallbackFailureException
import com.example.frontServer.security.AuthUserDetails
import com.example.frontServer.service.LikeService
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class LikeController(
    private val likeService: LikeService
) {
    private val logger = KotlinLogging.logger {}

    @PostMapping("/like")
    fun save(
        @RequestParam boardId: Long,
        @AuthenticationPrincipal user: AuthUserDetails
    ): ResponseEntity<ResponseToClientDto> {
        return try {
            val isSaved: Boolean = likeService.save(boardId, user.getUserId()) // not null
            if (isSaved) {
                ResponseEntity.ok().body(
                    ResponseToClientDto(
                        errorCode = ResponseCode.SUCCESS,
                        data = null
                    )
                )
            } else {
                 ResponseEntity.ok().body(
                    ResponseToClientDto(
                        errorCode = ResponseCode.SAVE_FAILURE,
                        data = null
                    )
                )
            }
        } catch (e: FallbackFailureException) {
            logger.error {e.message}
            return ResponseEntity.ok().body(
                ResponseToClientDto(
                    errorCode = ResponseCode.SAVE_FAILURE,
                    data = null
                )
            )
        }
    }

    @GetMapping("/like/users")
    fun findUsersByBoardId(
        @RequestParam boardId: Long
    ): ResponseEntity<ResponseToClientDto> {
        return ResponseEntity.ok().body(
            ResponseToClientDto(
                errorCode = ResponseCode.SUCCESS,
                data = likeService.findUserLikeThisBoard(boardId)
            )
        )
    }
}