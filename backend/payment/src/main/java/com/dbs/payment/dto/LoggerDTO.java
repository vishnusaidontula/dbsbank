package com.dbs.payment.dto;


import javax.validation.constraints.NotBlank;


import com.dbs.payment.model.Customer;
import com.dbs.payment.model.Transaction;

import lombok.Data;

@Data
public class LoggerDTO {
	private int loggerId;
	@NotBlank(message = "required screen name")
	private String screename;
	@NotBlank(message = "required action details")
	private String action;
	@NotBlank(message = "required ipaddress")
	private String ipaddress;
	@NotBlank(message = "required customer details")
	private Customer customer;
	@NotBlank(message = "required transaction details")
	private Transaction transaction;

}
