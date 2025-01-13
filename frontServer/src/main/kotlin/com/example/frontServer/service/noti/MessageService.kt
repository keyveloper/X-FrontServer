package com.example.frontServer.service.noti

import com.example.frontServer.entity.Board
import com.example.frontServer.enum.NotificationType
import org.springframework.context.MessageSource
import org.springframework.stereotype.Component
import java.util.*

@Component
class MessageService(
    private val messageSource: MessageSource
) {
    fun makeMessage(
        notiType: NotificationType,
        targetBoard: Board?,
        targetBoardId: Long?,
        username: String,
        language: String,
    ): String {

        val locale = Locale.forLanguageTag(language)
        return when(notiType) {
            NotificationType.BOARD -> {
                val builder: StringBuilder = StringBuilder()
                val textContent = targetBoard?.textContent?.take(25) ?: "???"
                val message = messageSource
                    .getMessage("noti.BOARD", arrayOf(targetBoardId, username), locale)

                builder.append(message + "\n")
                builder.append(textContent)
                builder.toString()
            }

            NotificationType.LIKE -> {
                messageSource.getMessage("noti.LIKE", arrayOf(username, targetBoard), locale)
            }
            NotificationType.FOLLOW -> messageSource.getMessage("noti.FOLLOW", arrayOf(username), locale)
        }
    }
}