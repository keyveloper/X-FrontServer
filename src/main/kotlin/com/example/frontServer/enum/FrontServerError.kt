package com.example.frontServer.enum

enum class FrontServerError {
    OK,
    INVALID_ID,              // invalid Id : boardId, userId,..
    DUPLICATED,              // unique key
}