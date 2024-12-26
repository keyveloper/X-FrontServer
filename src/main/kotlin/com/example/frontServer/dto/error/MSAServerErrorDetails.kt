package com.example.frontServer.dto.error

import com.example.frontServer.enum.MSAServerErrorCode

data class MSAServerErrorDetails( // common used
    val type: String?,     // error url
    val status: MSAServerErrorCode,      // Server Error Code --> 서버별로 따로 만들기가 어려워
    val title: String?,    // summary of Error
    val detail: String?,   //  (Optional but need)
)