package com.dbs.payment.exception;

public class BankNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	public BankNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	public BankNotFoundException(String message) {
		super(message);
	}
	public BankNotFoundException(Throwable cause) {
		super(cause);
	}
	public BankNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
