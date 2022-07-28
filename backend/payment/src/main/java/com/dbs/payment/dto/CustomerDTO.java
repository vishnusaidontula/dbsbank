package com.dbs.payment.dto;

import javax.validation.constraints.NotNull;

import com.dbs.payment.model.CustomerType;

import lombok.Data;
@Data
public class CustomerDTO {
	private int customerId;
	@NotNull(message = "Required account holder name")
	private String accountHolderName;
	private boolean overDraftFlag;
	private Double clearBalance;
	@NotNull(message = "Required customer address")
	private String address;
	@NotNull(message = "Required customer city")
	private String city;
	@NotNull(message = "Required customer type")
	private CustomerType type;
}
