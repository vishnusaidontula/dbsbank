package com.dbs.payment.exception;

public class TransferTypeNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	public TransferTypeNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	public TransferTypeNotFoundException(String message) {
		super(message);
	}
	public TransferTypeNotFoundException(Throwable cause) {
		super(cause);
	}
	public TransferTypeNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
