package com.example.demo.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map> handleException(EntityNotFoundException exception){
        Map<String, String> errorMessage = new HashMap<>();
        errorMessage.put("message", exception.getMessage());
        log.error("EntityNotFoundException occured: ", exception);
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map> handleGenericException(Exception exception){
        Map<String, String> errorMessage = new HashMap<>();
        errorMessage.put("message", exception.getMessage());
        log.error("GenericException occured {}: ", exception);
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
