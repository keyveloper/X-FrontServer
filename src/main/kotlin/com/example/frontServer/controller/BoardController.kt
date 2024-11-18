package com.example.frontServer.controller

import com.example.frontServer.dto.board.BoardAllResponse
import com.example.frontServer.dto.board.BoardResponse
import com.example.frontServer.dto.board.BoardSaveRequest
import com.example.frontServer.exception.InvalidIdException
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
    fun findAll(): ResponseEntity<BoardAllResponse> {
        val results  = boardService.findAll();
        return ResponseEntity.ok().body(
            BoardAllResponse(
                boardResults = results,
                errorResponse = null
            )
        )
    }

    @GetMapping("/board")
    fun findById(@RequestBody id: Long): ResponseEntity<BoardResponse> {
        return boardService.findById(id)?.let {
            ResponseEntity.ok().body(
                BoardResponse.of(it, null)
            )
        } ?: throw InvalidIdException()
    }

    @PostMapping("/board")
    fun save(
        @Valid @ModelAttribute saveBoardRequest: BoardSaveRequest,
        @AuthenticationPrincipal user: AuthUserDetails
    ): ResponseEntity<Void> {
        boardService.save(
            request = saveBoardRequest,
            userId = user.getUserId(),
            username = user.username
        )
        return ResponseEntity.ok().build()
    }
    // 예외 처리로 끝내기


    @DeleteMapping("/board")
    fun delete(@RequestParam id: Long): ResponseEntity<Void> {
        if (!boardService.deleteById(id)) {
            throw InvalidIdException()
        }
        return ResponseEntity.ok().build()
    }
    // 예외처리로 끝내기
}