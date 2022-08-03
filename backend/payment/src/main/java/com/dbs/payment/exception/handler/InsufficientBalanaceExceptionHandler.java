package com.dbs.payment.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dbs.payment.exception.InsufficientBalanaceException;


@RestControllerAdvice
public class InsufficientBalanaceExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(InsufficientBalanaceException exc) {
		
		ErrorResponse error = new ErrorResponse(
											HttpStatus.CONFLICT.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.CONFLICT);
	}

}
