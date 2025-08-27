package com.vs.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import feign.FeignException;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = BookNotFoundException.class)
	public ResponseEntity<Object> handleException(BookNotFoundException ex) {
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
        
        Map<String, String> res = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
            res.put(error.getField(), error.getDefaultMessage())
        );
        
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }

	 
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGenericException(Exception ex) {
	        ex.printStackTrace();
	        return new ResponseEntity<>("An unexpected error occurred.", HttpStatus.INTERNAL_SERVER_ERROR);
	 }
	 
}