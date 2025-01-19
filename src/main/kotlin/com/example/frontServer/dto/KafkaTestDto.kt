package com.example.frontServer.dto

data class KafkaTestDto(
    val id: Long,
    val message: String,
    val username: String?
)