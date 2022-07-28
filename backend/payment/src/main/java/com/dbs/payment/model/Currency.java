package com.dbs.payment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Currency {
	@Id
	@Column(length = 3)
	private String currencyCode;
	private String currencyName;
	private double conversionRate;
}
