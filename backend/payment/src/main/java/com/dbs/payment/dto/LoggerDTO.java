package com.dbs.payment.dto;


import javax.validation.constraints.NotNull;

import com.dbs.payment.model.Customer;
import com.dbs.payment.model.Employee;
import com.dbs.payment.model.Transaction;

import lombok.Data;

@Data
public class LoggerDTO {
	private int loggerId;
	@NotNull(message = "required screen name")
	private String screename;
	@NotNull(message = "required action details")
	private String action;
	@NotNull(message = "required ipaddress")
	private String ipaddress;
	@NotNull(message = "required customer details")
	private Customer customer;
	@NotNull(message="required employee details")
	private Employee employee;
	@NotNull(message = "required transaction details")
	private Transaction transaction;

}
