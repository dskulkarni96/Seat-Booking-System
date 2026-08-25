package com.seatbooking.inventory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String>handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException){
		return new ResponseEntity<>(resourceNotFoundException.getMessage(),HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(SeatNotAvailableException.class)
	public ResponseEntity<String>handleResourceNotFoundException(SeatNotAvailableException seatNotAvailableException){
		return new ResponseEntity<>(seatNotAvailableException.getMessage(),HttpStatus.CONFLICT);
	}
}
