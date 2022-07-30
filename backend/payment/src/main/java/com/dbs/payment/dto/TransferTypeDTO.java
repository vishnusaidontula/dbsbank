package com.dbs.payment.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
public class TransferTypeDTO {
	@NotNull(message="Transfer Type Required")
	private String transferTypeCode;
	private String description;
}
