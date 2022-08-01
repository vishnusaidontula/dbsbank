package com.dbs.payment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Currency {
	@Id
	@Column(length = 3)
	private String currencyCode;
	private String currencyName;
	@Column(columnDefinition="Decimal(10,2)")
	private double conversionRate;
}
