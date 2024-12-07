package com.example.frontServer.exception

import com.example.frontServer.dto.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.naming.AuthenticationException

@RestControllerAdvice
class GlobalExceptionHandler {
//    // validation error
//    @ExceptionHandler(MethodArgumentNotValidException::class)
//    fun handleValidationException(ex: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
//        val message = ex.bindingResult.allErrors.joinToString(", ") { error ->
//            val fieldError = error as FieldError
//            "${fieldError.field}: ${fieldError.defaultMessage}"
//        }
//        return ResponseEntity.ok().body(
//            ErrorResponse(
//                code = FrontServerCode.VALIDATION_ERROR,
//                message = message
//            )
//        )
//    }
//
//    // DB data Integrity Violations
//    @ExceptionHandler(DataIntegrityViolationException::class)
//    fun handleDataIntegrityViolationException(ex: DataIntegrityViolationException): ResponseEntity<ErrorResponse> {
//        val rootCause = ex.rootCause?.message ?: ex.message ?: ""
//
//        return when {
//            rootCause.contains("UNIQUE") -> ResponseEntity.ok().body(
//                ErrorResponse(
//                    code = FrontServerCode.DUPLICATED,
//                    message = "Duplicated value"
//                )
//            )
//            else -> ResponseEntity.ok().body(
//                ErrorResponse(
//                    code = FrontServerCode.BAD_REQUEST,
//                    message = "Something wrong..."
//                )
//            )
//        }
//    }
//
//    // DB Connection Error
//    @ExceptionHandler(CannotGetJdbcConnectionException::class)
//    fun handleDbConnectionException(ex: CannotGetJdbcConnectionException): ResponseEntity<ErrorResponse> {
//        return ResponseEntity.ok().body(
//            ErrorResponse(
//                code = FrontServerCode.FATAL_SERVER_ERROR,
//                message = "Fata Server Error..."
//            )
//        )
//    }
//
//    //  invalid request body
//    @ExceptionHandler(HttpMessageNotReadableException::class)
//    fun handleHttpMessageNotReadableException(ex: HttpMessageNotReadableException): ResponseEntity<ErrorResponse> {
//        return ResponseEntity.ok().body(
//            ErrorResponse(
//                code = FrontServerCode.PARSING_ERROR,
//                message = "Invalid Request Body"
//            )
//        )
//    }
//
//    // can't access resource for network error.
//    @ExceptionHandler(ResourceAccessException::class)
//    fun handleCredentialsException(ex: ResourceAccessException): ResponseEntity<ErrorResponse> {
//        return ResponseEntity.ok().body(
//            ErrorResponse(
//                code = FrontServerCode.CANNOT_ACCESS_RESOURCE,
//                message = "can't access resource for network error."
//            )
//        )
//    }
//
    // Authentication Error 처리
    @ExceptionHandler(AuthenticationException::class)
    fun handleAuthenticationException(ex: AuthenticationException): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("jwt인증에러 ")
    }

    // Invalid Id Error
    @ExceptionHandler(InvalidIdException::class)
    fun handleCustomErrorException(ex: CustomErrorException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.ok().body(
            ErrorResponse(
                code = ex.errorCode,
                message = ex.message
            )
        )
    }
}