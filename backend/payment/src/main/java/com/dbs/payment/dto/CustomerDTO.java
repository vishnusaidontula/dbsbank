package com.dbs.payment.dto;

import java.math.BigInteger;

import javax.validation.constraints.NotBlank;

import com.dbs.payment.model.CustomerType;

import lombok.Data;
@Data
public class CustomerDTO {
	private BigInteger customerId;
	@NotBlank(message = "Required account holder name")
	private String accountHolderName;
	@NotBlank(message = "Required customer address")
	private boolean overDraftFlag;
	@NotBlank(message = "Required customer address")
	private Double clearBalance;
	@NotBlank(message = "Required customer address")
	private String address;
	@NotBlank(message = "Required customer city")
	private String city;
	@NotBlank(message = "Required customer type")
	private CustomerType type;
}
