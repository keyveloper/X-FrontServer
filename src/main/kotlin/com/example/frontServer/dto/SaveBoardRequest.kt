package com.example.frontServer.dto

import jakarta.validation.constraints.NotEmpty
import org.springframework.web.multipart.MultipartFile

data class SaveBoardRequest(
    @field:NotEmpty
    val textContent: String,

    val imgFile: MultipartFile?,
    )
//