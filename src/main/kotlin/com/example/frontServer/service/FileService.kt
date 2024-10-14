package com.example.frontServer.service

import com.example.frontServer.dto.FilesDto
import com.example.frontServer.entity.BoardImg
import com.example.frontServer.repository.BoardImgRepository
import org.springframework.stereotype.Service
import java.io.File

@Service
class FileService(
    private val boardImgRepository: BoardImgRepository,
) {
    fun saveBoardFile(fileDtos: FilesDto, token: String): Boolean {
        val rootPath = "\"C:\\Users\\dideh\\Desktop\\Spring\\img\""
        val dirPath = "$rootPath\\$token"
        File(dirPath).mkdirs()

        fileDtos.files.forEach { file ->
            val filename = file.originalFilename
            val filePath = "$dirPath//$filename"
            val newFile = File(filePath)

            file.transferTo(newFile)

            boardImgRepository.save(
                BoardImg(
                    filename= filename!!,
                    token = token,
                    url = filePath
                )
            )
        }
        return true
    }
}