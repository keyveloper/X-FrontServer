package com.example.frontServer.controller

import com.example.frontServer.dto.ResponseToClientDto
import com.example.frontServer.service.FileService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FileController(
    private val fileService: FileService
) {
    @GetMapping("/img/:{boardId}")
    fun findImgByBoardId(
        @PathVariable boardId: Long
    ): ResponseEntity<ResponseToClientDto> {

    }
}