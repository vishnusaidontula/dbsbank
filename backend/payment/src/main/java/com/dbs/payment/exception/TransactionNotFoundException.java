package com.dbs.payment.exception;

public class TransactionNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	public TransactionNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	public TransactionNotFoundException(String message) {
		super(message);
	}
	public TransactionNotFoundException(Throwable cause) {
		super(cause);
	}
	public TransactionNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}


}
