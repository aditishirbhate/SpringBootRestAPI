package com.aditi.springbootrestapi.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleResourceNotFound(ResourceNotFoundException ex){

        Map<String,Object> response=new HashMap<>();

        response.put("time",LocalDateTime.now());
        response.put("message",ex.getMessage());
        response.put("status",404);

        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> validationException(MethodArgumentNotValidException ex){

        Map<String,String> errors=new HashMap<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(error->errors.put(error.getField(),error.getDefaultMessage()));

        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);

    }

}