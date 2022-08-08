package com.dbs.payment.model;



import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="customer")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Customer{
	@Id
	@Column(length = 14,columnDefinition = "BIGINT")
	private BigInteger customerId;
	private String accountHolderName;
	private boolean overDraftFlag;
	@Column(columnDefinition="Decimal(10,2)")
	private double clearBalance;
	private String address;
	private String city;
	private CustomerType type;
	
	
	
}
