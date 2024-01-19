package com.peaksoft.gadgetariumj7.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MainHandler {
    @ExceptionHandler(NotFoundExcepption.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse notFoundException(NotFoundExcepption e) {
        return new ExceptionResponse(HttpStatus.NOT_FOUND, e.getClass().getName(), e.getMessage());
    }

    @ExceptionHandler(IncorrectCodeException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ExceptionResponse incorrectCodeException(IncorrectCodeException i) {
        return new ExceptionResponse(HttpStatus.FORBIDDEN, i.getClass().getName(), i.getMessage());
    }

}
