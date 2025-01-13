package com.example.frontServer.dto.file

import org.springframework.web.multipart.MultipartFile

data class FileRequest(
    val files: List<MultipartFile>
)