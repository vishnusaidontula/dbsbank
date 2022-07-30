package com.dbs.payment.exception;

public class MessageNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	public MessageNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	public MessageNotFoundException(String message) {
		super(message);
	}
	public MessageNotFoundException(Throwable cause) {
		super(cause);
	}
	public MessageNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
