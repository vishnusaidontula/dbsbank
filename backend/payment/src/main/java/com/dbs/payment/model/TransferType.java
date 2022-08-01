package com.dbs.payment.model;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="transfertypes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TransferType {
	@Id
	private String transferTypeCode;
	private String description;
}
