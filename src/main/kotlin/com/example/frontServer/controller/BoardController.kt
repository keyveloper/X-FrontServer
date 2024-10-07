package com.example.frontServer.controller

import com.example.frontServer.dto.*
import com.example.frontServer.security.AuthUserDetails
import com.example.frontServer.service.BoardService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*

@RestController
class BoardController(
    private val boardService: BoardService,
) {

    @GetMapping("/boards")
    fun findBoards(): ResponseEntity<List<GetAllBoardResponse>> {
        val results : List<GetAllBoardResult> = boardService.findAll();
        return ResponseEntity.ok().body(results.map { GetAllBoardResponse.of(it) })
    }

    @GetMapping("/board")
    fun findById(@RequestParam id: Long): ResponseEntity<GetBoardResponse> {
        val result : GetBoardResult? = boardService.findById(id)
        if (result != null) {
            return ResponseEntity.ok().body(GetBoardResponse.of(result))
        }//
        return ResponseEntity.notFound().build()
    }

    @PostMapping("/board")
    fun save(
        @Valid @RequestBody saveBoardRequest: SaveBoardRequest,
        @AuthenticationPrincipal user: AuthUserDetails
    ): ResponseEntity<String> {
        val message = boardService.save(saveBoardRequest, user.username)
        return ResponseEntity.ok().body(message)
    }

    @PostMapping("/board-reply")
    fun saveReply(
        @Valid @RequestBody saveReplyRequest: SaveReplyRequest,
        @AuthenticationPrincipal user: AuthUserDetails
    ): ResponseEntity<String> {
        val message = boardService.saveReply(saveReplyRequest, user.username)
        return ResponseEntity.ok().body(message)
    }

    @DeleteMapping("/board")
    fun delete(@RequestParam id: Long): ResponseEntity<String> {
        val message = boardService.deleteById(id)
        return ResponseEntity.ok().body(message)
    }
}