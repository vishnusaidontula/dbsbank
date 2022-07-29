package com.dbs.payment.exception;

public class EmployeeNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	public EmployeeNotFoundException()
	{
		super();
	}
	public EmployeeNotFoundException(String message)
	{
		super(message);
	}
	public EmployeeNotFoundException(Throwable cause) {
		super(cause);
	}
	public EmployeeNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
