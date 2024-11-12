package com.example.frontServer.dto.board

import com.example.frontServer.dto.FilesDto
import jakarta.validation.constraints.NotEmpty

data class SaveBoardRequest(
    @field:NotEmpty
    val textContent: String,

    val files: FilesDto? = null,
    )
//