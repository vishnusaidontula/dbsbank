package com.dbs.payment.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EmployeeDTO {
	private int employeeId;
	@NotNull(message = "Employee name is required")
	private String employeeName;
	@NotNull(message = "Password is Required")
	private String password;
}
