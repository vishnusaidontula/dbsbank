package com.dbs.payment.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dbs.payment.exception.CustomerNotFoundException;

@ControllerAdvice
public class CustomerExceptionHandler {
		@ExceptionHandler
		public ResponseEntity<ErrorResponse> handleException(CustomerNotFoundException exc) {
			
			ErrorResponse error = new ErrorResponse(
												HttpStatus.NOT_FOUND.value(),
												exc.getMessage(),
												System.currentTimeMillis());
			
			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		}
}
