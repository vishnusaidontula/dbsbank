package com.dbs.payment.dto;

import java.time.LocalDate;


import javax.validation.constraints.NotNull;

import com.dbs.payment.model.Bank;
import com.dbs.payment.model.Currency;
import com.dbs.payment.model.Customer;
import com.dbs.payment.model.Message;
import com.dbs.payment.model.TransferType;

import lombok.Data;

@Data
public class TransactionDTO {
	private int transactionId;
	@NotNull(message="require customer details")
	private Customer customer;
	@NotNull(message="require currency details")
	private Currency currency;
	@NotNull(message="require sender bic details")
	private Bank senderBIC;
	@NotNull(message="require receiver bic details")
	private Bank receiverBIC;
	@NotNull(message="require receiver account number details")
	private String receiverAccountHolderNumber;
	@NotNull(message="require receiver account holder name details")
	private String receiverAccountHolderName;
	@NotNull(message="require transfer type details")
	private TransferType transferType;
	private Message message;
	@NotNull(message="require currency amount details")
	private double currencyAmount;
	@NotNull(message="require trasfer fee details")
	private double transferFee;
	@NotNull(message="require inr amount details")
	private double inrAmount;
	@NotNull(message="require transfer date details")
	private LocalDate transferDate;

}
