package com.seatbooking.catalog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> HandleResourceNotFoundException(ResourceNotFoundException resourceNotFound){
		
		return new ResponseEntity<>(resourceNotFound.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(UnableToDeleteResourceException.class)
	public ResponseEntity<String> handleUnableToDeleteResourceException(UnableToDeleteResourceException resourceNotFound){
		
		return new ResponseEntity<>(resourceNotFound.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ResourceAlreadyExistsException.class)
	public ResponseEntity<String> handleResourceAlreadyExistsException(ResourceAlreadyExistsException resourceNotFound){
		
		return new ResponseEntity<>(resourceNotFound.getMessage(), HttpStatus.NOT_FOUND);
	}
}
