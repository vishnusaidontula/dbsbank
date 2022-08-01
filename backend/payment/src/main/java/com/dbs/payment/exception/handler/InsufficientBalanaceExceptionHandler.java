package com.dbs.payment.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dbs.payment.exception.InsufficientBalanaceException;


@ControllerAdvice
public class InsufficientBalanaceExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(InsufficientBalanaceException exc) {
		
		ErrorResponse error = new ErrorResponse(
											HttpStatus.NOT_FOUND.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}
