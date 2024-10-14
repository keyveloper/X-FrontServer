package com.example.frontServer.exception

import com.example.frontServer.dto.ResponseToClientDto
import com.example.frontServer.enum.ResponseCode
import io.jsonwebtoken.io.IOException
import org.springframework.http.ResponseEntity
import org.springframework.security.access.AccessDeniedException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.client.ResourceAccessException

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler
    fun handleIOException(ex: IOException): ResponseEntity<ResponseToClientDto> {
        return ResponseEntity.ok().body(
            ResponseToClientDto(
                errorCode = ResponseCode.CONNECTION_ERROR,
                data = null
            )
        )
    }

    @ExceptionHandler
    fun handleParameterException(ex: MissingServletRequestParameterException): ResponseEntity<ResponseToClientDto> {
        return ResponseEntity.ok().body(
            ResponseToClientDto(
                errorCode = ResponseCode.PARAMETER_ERROR,
                data = null
            )
        )
    }

    @ExceptionHandler
    fun handleValidationException(ex: MethodArgumentNotValidException): ResponseEntity<ResponseToClientDto> {
        return ResponseEntity.ok().body(
            ResponseToClientDto(
                errorCode = ResponseCode.VALIDATION_ERROR,
                data = null
            )
        )
    }

    @ExceptionHandler
    fun handleCredentialsException(ex: ResourceAccessException): ResponseEntity<ResponseToClientDto> {
        return ResponseEntity.ok().body(
            ResponseToClientDto(
                errorCode = ResponseCode.CREDENTIALS_ERROR,
                data = null
            )
        )
    }

    @ExceptionHandler
    fun handleAccessDeniedException(ex: AccessDeniedException): ResponseEntity<ResponseToClientDto> {
        return ResponseEntity.ok().body(
            ResponseToClientDto(
                errorCode = ResponseCode.ACCESS_DENIED,
                data = null
            )
        )
    }

    @ExceptionHandler
    fun handleNotFoundEntityException(ex: NotFoundEntityException): ResponseEntity<ResponseToClientDto> {
        return ResponseEntity.ok().body(
            ResponseToClientDto(
                errorCode = ResponseCode.NOT_FOUND_ENTITY,
                data = null
            )
        )
    }

    @ExceptionHandler
    fun handleEntitySaveFailureException(ex: EntitySaveFailure): ResponseEntity<ResponseToClientDto> {
        return ResponseEntity.ok().body(
            ResponseToClientDto(
                errorCode = ResponseCode.SAVE_FAILURE,
                data = null
            )
        )
    }

    @ExceptionHandler
    fun handleEntityDeleteFailureException(ex: EntityDeleteFailureException): ResponseEntity<ResponseToClientDto> {
        return ResponseEntity.ok().body(
            ResponseToClientDto(
                errorCode = ResponseCode.DELETE_FAILURE,
                data = null
            )
        )
    }
}