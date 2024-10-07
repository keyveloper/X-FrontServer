package com.example.frontServer.service

import com.example.frontServer.dto.GetAllBoardResult
import com.example.frontServer.dto.GetBoardResult
import com.example.frontServer.dto.SaveBoardRequest
import com.example.frontServer.dto.SaveReplyRequest
import com.example.frontServer.entity.Board
import com.example.frontServer.enum.BoardType
import com.example.frontServer.repository.BoardRepository
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.nio.file.Files
import java.nio.file.Paths

@Service
class BoardService(
    val boardRepository: BoardRepository
) {
    @Value("\${file.upload-dir}")
    private lateinit var uploadDirectory: String

    fun findAll() : List<GetAllBoardResult> {
        val boards : List<Board> = boardRepository.findAll()
        return boards.map { GetAllBoardResult.of(it, countRepliesById(it.id!!)) }
    }

    @Transactional
    fun findById(id: Long): GetBoardResult? {
        val board : Board? = boardRepository.findById(id).orElse(null) // optional -> ?

        return board?.let {
            addReadingCount(it)
            GetBoardResult.of(it)
        }
    }

    private fun addReadingCount(board: Board) {
        board.readingCount++
        boardRepository.save(board)
    }

    fun save(request: SaveBoardRequest, username: String) : String {
        return try {
            var imgUrl : String? = null
            if (request.imgFile != null && !request.imgFile.isEmpty) {
                imgUrl = saveFile(request.imgFile)
            }

            val board = Board(
                writer = username,
                textContent = request.textContent,
                imgUri = imgUrl,
                readingCount = 0,
                likeCount = 0,
                type = BoardType.NORMAL
            )
            boardRepository.save(board)
            "save board successfully"
        } catch (e: Exception) {
            throw e
        }
    }

    @Transactional
    // check id exist
    fun saveReply(request: SaveReplyRequest, username: String): String {
        return try {
            var imgUrl : String? = null
            if (request.imgFile != null && !request.imgFile.isEmpty) {
                imgUrl = saveFile(request.imgFile)
            }
            if (boardRepository.existsById(request.parentId.toLong())) {
                val board = Board(
                    writer = username,
                    textContent = request.textContent,
                    imgUri = imgUrl,
                    readingCount = 0,
                    likeCount = 0,
                    type = BoardType.NORMAL,
                    parentId = request.parentId
                )
                boardRepository.save(board)
                "save board successfully"
            } else {
                "no exist Id"
            }
        } catch (e: Exception) {
            throw e
        }
    }

    fun deleteById(id: Long): String {
        boardRepository.deleteById(id)
        return "delete Successfully"
    }

    private fun saveFile(file: MultipartFile): String {
        val fileName = file.originalFilename ?: "unknown.jpg"
        val filePath = Paths.get(uploadDirectory, fileName)
        file.inputStream.use { inputStream ->
            Files.copy(inputStream, filePath)
        }

        // url 생성
        return ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/image/")
            .path(fileName)
            .toUriString()
    }//

    private fun countRepliesById(id: Long) : Long {
        return boardRepository.countRepliesById(id)
    }
}