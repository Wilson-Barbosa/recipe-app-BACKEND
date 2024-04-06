package com.cuisinehub.recipes.exceptions;

import java.time.Instant;
import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class DatabaseExceptionHandler {
    
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorDetails> userDataAlreadyTaken(RuntimeException exception){

        // Creating an instance of ErrorDetails that will be thrown instead of RuntimeException
        ErrorDetails error = new ErrorDetails();

        // Populating the error with information
        error.setTime(Instant.now());
        error.setMessage("Your request was not processed");
        error.setError(exception.getMessage());
        
        // Sending back the body and the status code
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

}
