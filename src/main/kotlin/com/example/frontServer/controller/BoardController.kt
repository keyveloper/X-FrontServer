package com.example.frontServer.controller

import com.example.frontServer.dto.*
import com.example.frontServer.dto.board.BoardResponse
import com.example.frontServer.dto.board.BoardSaveRequest
import com.example.frontServer.exception.InValidIdException
import com.example.frontServer.security.AuthUserDetails
import com.example.frontServer.service.BoardService
import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*

@RestController
class BoardController(
    private val boardService: BoardService,
) {
    private val logger = KotlinLogging.logger {}

    @GetMapping("/boards")
    fun findAll(): ResponseEntity<List<BoardResponse>> {
        val results  = boardService.findAll();
        return ResponseEntity.ok().body(
            results.map {
                BoardResponse.of(it)
            }
        )
    }

    @GetMapping("/board")
    fun findById(@RequestBody id: Long): ResponseEntity<BoardResponse> {
        return boardService.findById(id)?.let {
            ResponseEntity.ok().body(
                BoardResponse.of(it)
            )
        } ?: throw InValidIdException()
    }

    @PostMapping("/board")
    fun save(
        @Valid @ModelAttribute saveBoardRequest: BoardSaveRequest,
        @AuthenticationPrincipal user: AuthUserDetails
    ): ResponseEntity<ResponseToClientDto> {
        logger.info { "start save baord!! " }
        if (boardService.save(saveBoardRequest, user.getUserId(), user.username)) {

        } else throw EntitySaveFailure()
    }


    @DeleteMapping("/board")
    fun delete(@RequestParam id: Long): ResponseEntity<BoardResponse> {
        if (boardService.deleteById(id)) {
            return ResponseEntity.badRequest().body(
                ResponseToClientDto(
                    errorCode = null,
                    data = null
                )
            )
        } else throw EntityDeleteFailureException()
    }
}