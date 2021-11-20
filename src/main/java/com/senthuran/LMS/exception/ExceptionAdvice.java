package com.senthuran.LMS.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleGenericNotFoundException(ResourceNotFoundException e) {
        CustomErrorResponse error = new CustomErrorResponse("NOT_FOUND_ERROR", e.getMessage());
        error.setTimestamp(LocalDateTime.now());
        error.setStatus((HttpStatus.NOT_FOUND.value()));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = RecordFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleRecordFoundException(RecordFoundException e) {
        CustomErrorResponse error = new CustomErrorResponse("RECORD_FOUND_ERROR", e.getMessage());
        error.setTimestamp(LocalDateTime.now());
        error.setStatus((HttpStatus.FOUND.value()));
        return new ResponseEntity<>(error, HttpStatus.FOUND);
    }
}
