package com.example.frontServer.repository

interface BoardQueryDslRepository {
    fun countRepliesById(id: Long) : Long
}