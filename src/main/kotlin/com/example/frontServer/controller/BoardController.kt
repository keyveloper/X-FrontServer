package com.example.frontServer.controller

import com.example.frontServer.dto.board.BoardAllResponse
import com.example.frontServer.dto.board.BoardResponse
import com.example.frontServer.dto.board.BoardSaveRequest
import com.example.frontServer.dto.timeline.TimelineBoardResponse
import com.example.frontServer.dto.timeline.TimelineRequest
import com.example.frontServer.exception.InvalidIdException
import com.example.frontServer.security.AuthUserDetails
import com.example.frontServer.service.board.BoardService
import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.validation.Valid
import org.apache.coyote.Response
import org.springframework.http.MediaType
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
            BoardAllResponse(results)
        )
    }

    @GetMapping("/board")
    fun findById(@RequestBody id: Long): ResponseEntity<BoardResponse> {
        return boardService.findById(id)?.let {
            ResponseEntity.ok().body(
                BoardResponse.of(it)
            )
        } ?: throw InvalidIdException()
    }

    @PostMapping("/board/timeline/next")
    fun findTimelineNext(
        @RequestBody timelineRequest: TimelineRequest
    ): ResponseEntity<List<TimelineBoardResponse>> {
        return ResponseEntity.ok().body(
            boardService.findTimelineNext(timelineRequest)
                .map { TimelineBoardResponse.of(it) }
        )
    }

    @PostMapping("/board/timeline/prev")
    fun findTimelineBefore(
        @RequestBody timelineRequest: TimelineRequest
    ): ResponseEntity<List<TimelineBoardResponse>> {
        return ResponseEntity.ok().body(
            boardService.findTimelineBefore(timelineRequest)
                .map { TimelineBoardResponse.of(it) }
        )
    }

    @PostMapping("/board")
    fun save(
        @Valid @RequestBody saveBoardRequest: BoardSaveRequest,
        @AuthenticationPrincipal user: AuthUserDetails
    ): ResponseEntity<Void> {
        boardService.save(
            request = saveBoardRequest,
            writerId = user.getUserId(),
            writerName = user.username
        )
        return ResponseEntity.ok().build()
    }


    @DeleteMapping("/board")
    fun delete(@RequestParam id: Long): ResponseEntity<Void> {
        if (!boardService.deleteById(id)) {
            throw InvalidIdException()
        }
        return ResponseEntity.ok().build()
    }
}