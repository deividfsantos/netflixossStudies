package com.musicservicepoc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Error> notFoundException(){
        Error error = new Error("Error");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
