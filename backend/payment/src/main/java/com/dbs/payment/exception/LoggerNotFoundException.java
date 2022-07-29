package com.dbs.payment.exception;

public class LoggerNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public LoggerNotFoundException() {
	}
	public LoggerNotFoundException(String message) {
		super(message);
	}
	public LoggerNotFoundException(Throwable cause) {
		super(cause);
	}
	public LoggerNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
