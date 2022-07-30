package com.dbs.payment.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message {
	@Id
	@Column(length = 4)
	private String messageCode;
	private String instruction;
}
