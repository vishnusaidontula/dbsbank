package com.dbs.payment.exception;

public class CustomerNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	public CustomerNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	public CustomerNotFoundException(String message) {
		super(message);
	}
	public CustomerNotFoundException(Throwable cause) {
		super(cause);
	}
	public CustomerNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
