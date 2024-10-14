package com.example.frontServer.controller

import com.example.frontServer.dto.*
import com.example.frontServer.exception.EntityDeleteFailureException
import com.example.frontServer.exception.EntitySaveFailure
import com.example.frontServer.exception.NotFoundEntityException
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
    fun findBoards(): ResponseEntity<ResponseToClientDto> {
        val results : List<GetAllBoardResult> = boardService.findAll();
        return ResponseEntity.ok().body(
            ResponseToClientDto(
                errorCode = null,
                data = results.map {GetAllBoardResponse.of(it)}
            )
        )
    }

    @GetMapping("/board")
    fun findById(@RequestParam id: Long): ResponseEntity<ResponseToClientDto> {
        return boardService.findById(id)?.let {
            ResponseEntity.ok().body(
                ResponseToClientDto(
                    errorCode = null,
                    data = GetBoardResponse.of(it)
                )
            )
        } ?: run {
            throw NotFoundEntityException("boardId: $id not found")
        }
        // Exception : notFound
    }

    @PostMapping("/board")
    fun save(
        @Valid @ModelAttribute saveBoardRequest: SaveBoardRequest,
        @AuthenticationPrincipal user: AuthUserDetails
    ): ResponseEntity<ResponseToClientDto> {
        if (boardService.save(saveBoardRequest, user.getUserId(), user.username)) {
            return ResponseEntity.badRequest().body(
                ResponseToClientDto(
                    errorCode = null,
                    data = null
                )
            )
        } else throw EntitySaveFailure("save Board Failure")
    }


    @DeleteMapping("/board")
    fun delete(@RequestParam id: Long): ResponseEntity<ResponseToClientDto> {
        if (boardService.deleteById(id)) {
            return ResponseEntity.badRequest().body(
                ResponseToClientDto(
                    errorCode = null,
                    data = null
                )
            )
        } else throw EntityDeleteFailureException("Delete Board failure")
    }
}