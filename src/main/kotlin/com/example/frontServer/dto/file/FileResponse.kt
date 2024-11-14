package com.example.frontServer.dto.file

import com.example.frontServer.dto.ErrorResponse

data class FileResponse(
    val fileResult: FileResult?,
    val errorResponse: ErrorResponse?,
)