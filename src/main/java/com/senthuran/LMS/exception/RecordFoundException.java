package com.senthuran.LMS.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FOUND)
public class RecordFoundException extends Exception{

    private static final long serialVersionUID = 1L;

    public RecordFoundException(String message) {
        super(message);
    }
}
