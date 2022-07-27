package com.dbs.payment.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 14)
	private int customerId;
	private String accountHolderName;
	private boolean overDraftFlag;
	private Double clearBalance;
	private String address;
	private String city;
	private char type;
	
	
	
}
