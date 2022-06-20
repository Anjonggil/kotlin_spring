package com.example.mvc.advice

import com.example.mvc.domain.Error
import com.example.mvc.domain.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class GlobalControllerAdvice {

    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun exception(e : ConstraintViolationException): ResponseEntity<ErrorResponse>{
        val errors = mutableListOf<Error>()

        e.constraintViolations.forEach {
            val field = it.propertyPath.last().name
            val message= it.message

            val error = Error().apply {
                this.field = field
                this.message = message
                this.value = it.invalidValue
            }

            errors.add(error)
        }
        val errorResponse = ErrorResponse().apply {
            this.resultCode = "FAIL"
            this.httpStatus = HttpStatus.BAD_REQUEST.value().toString()
            this.message = "요청에 에러가 발생했습니다."
            this.path = ""
            this.timestamp = LocalDateTime.now()
            this.errors = errors
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse)
    }
}