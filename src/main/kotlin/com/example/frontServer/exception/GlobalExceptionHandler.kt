package com.example.frontServer.exception

import com.example.frontServer.dto.ErrorResponse
import com.example.frontServer.enum.FrontServerError
import io.jsonwebtoken.io.IOException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.jdbc.CannotGetJdbcConnectionException
import org.springframework.security.access.AccessDeniedException
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.client.ResourceAccessException

@RestControllerAdvice
class GlobalExceptionHandler {
    // validation error
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationException(ex: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
        val message = ex.bindingResult.allErrors.joinToString(", ") { error ->
            val fieldError = error as FieldError
            "${fieldError.field}: ${fieldError.defaultMessage}"
        }
        return ResponseEntity.ok().body(
            ErrorResponse(
                code = FrontServerError.VALIDATION_ERROR,
                message = message
            )
        )
    }

    // DB data Integrity Violations
    @ExceptionHandler(DataIntegrityViolationException::class)
    fun handleDataIntegrityViolationException(ex: DataIntegrityViolationException): ResponseEntity<ErrorResponse> {
        val rootCause = ex.rootCause?.message ?: ex.message ?: ""

        return when {
            rootCause.contains("UNIQUE") -> ResponseEntity.ok().body(
                ErrorResponse(
                    code = FrontServerError.DUPLICATED,
                    message = "Duplicated value"
                )
            )
            else -> ResponseEntity.ok().body(
                ErrorResponse(
                    code = FrontServerError.BAD_REQUEST,
                    message = "Something wrong..."
                )
            )
        }
    }

    // DB Connection Error
    @ExceptionHandler(CannotGetJdbcConnectionException::class)
    fun handleDbConnectionException(ex: CannotGetJdbcConnectionException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.ok().body(
            ErrorResponse(
                code = FrontServerError.FATAL_SERVER_ERROR,
                message = "Fata Server Error..."
            )
        )
    }

    //  invalid request body
    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleHttpMessageNotReadableException(ex: HttpMessageNotReadableException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.ok().body(
            ErrorResponse(
                code = FrontServerError.PARSING_ERROR,
                message = "Invalid Request Body"
            )
        )
    }

    // can't access resource for network error.
    @ExceptionHandler(ResourceAccessException::class)
    fun handleCredentialsException(ex: ResourceAccessException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.ok().body(
            ErrorResponse(
                code = FrontServerError.CANNOT_ACCESS_RESOURCE,
                message = "can't access resource for network error."
            )
        )
    }//

    // Access Denied 필요


    // Invalid Id Error
    @ExceptionHandler(InValidIdException::class)
    fun handleCustomErrorException(ex: CustomErrorException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.ok().body(
            ErrorResponse(
                code = ex.errorCode,
                message = ex.message
            )
        )
    }
}