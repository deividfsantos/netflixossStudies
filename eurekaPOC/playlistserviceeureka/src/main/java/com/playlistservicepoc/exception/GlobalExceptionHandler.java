package com.playlistservicepoc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

    @ExceptionHandler(value = APINotFoundException.class)
    public ResponseEntity<Error> apiNotFoundException(){
        Error error = new Error("API Not Found Exception");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
