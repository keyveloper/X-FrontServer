package com.example.frontServer.enum

enum class FrontServerError {
    NOT_FOUND_404,           // Wrong URL
    INVALID_ID,              // invalid Id : boardId, userId, ....
    DUPLICATED,              // unique key
    BAD_REQUEST,             // HTTP BAD_REQUEST
    UNEXPECTED_ERROR,        // UnExpected case
    FATAL_SERVER_ERROR,      // fatal server error ex) db connection error
    PARAMETER_ERROR,         // Parameter missing
    VALIDATION_ERROR,        // Sign-up or param validation error
    PARSING_ERROR,           // can't read request body
    CANNOT_ACCESS_RESOURCE,  // can't access resources for network
    CREDENTIALS_ERROR,       // Login failed
    ACCESS_DENIED,           // Failed access to premium service
    BODY_TYPE_ERROR,
    FILE_NOT_EXIST,
}