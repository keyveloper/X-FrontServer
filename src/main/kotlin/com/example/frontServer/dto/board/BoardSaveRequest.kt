package com.example.frontServer.dto.board

import com.example.frontServer.dto.file.FileRequest
import jakarta.validation.constraints.NotEmpty

data class BoardSaveRequest(
    @field:NotEmpty
    val textContent: String,

    val files: FileRequest? = null,
    )
//