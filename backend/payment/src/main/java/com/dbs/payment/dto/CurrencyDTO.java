package com.dbs.payment.dto;

import lombok.Data;

@Data
public class CurrencyDTO {
	private String currencyCode;
	private String currencyName;
	private double conversionRate;
}
