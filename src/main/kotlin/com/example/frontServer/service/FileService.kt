package com.example.frontServer.service

import com.example.frontServer.dto.file.FileRequest
import com.example.frontServer.dto.file.FileResult
import com.example.frontServer.entity.BoardImg
import com.example.frontServer.repository.board.BoardImgRepository
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File

@Service
class FileService(
    private val boardImgRepository: BoardImgRepository,
) {
    fun saveBoardFile(fileRequest: FileRequest, token: String) {
        val rootPath = "\"C:\\Users\\dideh\\Desktop\\Spring\\img\""
        val dirPath = "$rootPath\\$token"
        File(dirPath).mkdirs()

        fileRequest.files.forEach { file ->
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
    }

    fun findFilesByToken(token: String): FileResult? {
        val filePaths= boardImgRepository.findAllByToken(token).map {it.url}

        val multipartFiles: List<MultipartFile> = filePaths.map { filePath ->
            val file = File(filePath)

            CustomMultipartFile(file)
        }
        return FileResult.of(files = multipartFiles)
    }
}