package com.dbs.payment.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dbs.payment.exception.LoggerNotFoundException;

@RestControllerAdvice
public class LoggerExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(LoggerNotFoundException exc) {
		
		ErrorResponse error = new ErrorResponse(
											HttpStatus.NOT_FOUND.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}
