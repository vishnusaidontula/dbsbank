package com.dbs.payment.model;

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
@Table(name="bank")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Bank {
	@Id
	@Column(length = 11)
	private String bic;
	private String bankName;
}
