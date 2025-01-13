package com.example.frontServer.dto.file

import org.springframework.web.multipart.MultipartFile

data class FileResult(
    val files: List<MultipartFile>
) {
    companion object {
        fun of(files: List<MultipartFile>):FileResult {
            return FileResult(files)
        }
    }
}