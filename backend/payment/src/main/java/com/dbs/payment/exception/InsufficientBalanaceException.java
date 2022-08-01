package com.dbs.payment.exception;

public class InsufficientBalanaceException extends Exception {

	private static final long serialVersionUID = 1L;
	public InsufficientBalanaceException() {
		// TODO Auto-generated constructor stub
	}
	
	public InsufficientBalanaceException(String message) {
		// TODO Auto-generated method stub
		 super(message);
	}
	public InsufficientBalanaceException(Throwable cause) {
		// TODO Auto-generated method stub
		 super(cause);
	}
	public InsufficientBalanaceException(String message,Throwable cause) {
		// TODO Auto-generated method stub
		 super(message,cause);
	}
}
