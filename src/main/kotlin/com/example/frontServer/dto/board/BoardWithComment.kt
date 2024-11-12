package com.example.frontServer.dto.board

import com.example.frontServer.entity.Board
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

data class BoardWithComment(
    val board: Board,
    val jsonComments: String?
    ) {
    fun getCommentCount(): Int {
        val objectMapper = ObjectMapper()
        val comments: List<Map<String, Any>> = objectMapper.readValue(jsonComments)
        return comments.size
    }
}