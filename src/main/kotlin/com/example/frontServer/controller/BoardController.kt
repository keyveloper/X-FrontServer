package com.example.frontServer.controller

import com.example.frontServer.dto.board.request.*
import com.example.frontServer.dto.board.response.CommentResponse
import com.example.frontServer.dto.board.response.SingleBoardResponse
import com.example.frontServer.dto.board.response.SingleBoardResult
import com.example.frontServer.entity.Board
import com.example.frontServer.security.AuthUserDetails
import com.example.frontServer.service.board.BoardService
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

    // save
    @PostMapping("/saveBoard")
    fun save(
        @Valid @RequestBody saveBoardRequest: BoardSaveRequest,
        @AuthenticationPrincipal user: AuthUserDetails,
        @RequestHeader(value = "Accept-Language", defaultValue = "en") language: String,
    ): ResponseEntity<Void> {
        boardService.save(
            request = saveBoardRequest,
            writerId = user.getUserId(),
            writerName = user.username,
            language = language,
        )
        return ResponseEntity.ok().build()
    }

    // delete
    // 1. 조회 -> delete() 호출
    @DeleteMapping("/board")
    fun deleteById(request: BoardDeleteRequest): ResponseEntity<Void> {
        val result = boardService.deleteById(request.targetId)
        return if (result != null) {
           ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }

    // update
    // case 1. 영속성 컨텍스트를 직접 변경 - 죄회후 필드 변경 후 save
    // case 2. 바로 DB에 쿼리 날리기 - 영속성 컨텍스트와 동기화 되지 않음.
    @PostMapping("/updateBoard")
    fun updateContentById(request: BoardUpdateRequest): ResponseEntity<Board> {
        val result = boardService.updateContentById(request)
        return if (result != null) {
            ResponseEntity.ok().body(result)
        } else {
            ResponseEntity.badRequest().build()
        }
    }

    @PostMapping("/getComment/init")
    fun findInItComment(
        @Valid @RequestBody request: CommentGetRequest
    ): ResponseEntity<CommentResponse> {
        return ResponseEntity.ok().body(
            CommentResponse.of(
                boardService.findInitComment(request)
            )
        )
    }

    @PostMapping("/getComment/Next")
    fun findNextComment(
        @Valid @RequestBody request: CommentGetRequest
    ): ResponseEntity<CommentResponse> {
        return ResponseEntity.ok().body(
            CommentResponse.of(
                boardService.findNextComment(request)
            )
        )
    }

    @PostMapping("/getSingleBoard")
    fun findSingleBoard(
        @Valid @RequestBody request: SingleBoardRequest
    ): ResponseEntity<SingleBoardResponse> {
        return ResponseEntity.ok().body(
            SingleBoardResponse.of(
                boardService.findSingleBoard(request)
            )
        )
    }

}