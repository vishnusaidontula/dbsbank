package com.dbs.payment.exception;

public class CurrencyNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	public CurrencyNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	public CurrencyNotFoundException(String message) {
		super(message);
	}
	public CurrencyNotFoundException(Throwable cause) {
		super(cause);
	}
	public CurrencyNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
