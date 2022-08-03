package com.dbs.payment.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.dbs.payment.model.Bank;
import com.dbs.payment.model.Currency;
import com.dbs.payment.model.Customer;
import com.dbs.payment.model.Message;
import com.dbs.payment.model.TransferType;

import lombok.Data;

@Data
public class TransactionDTO {
	private int transactionId;
	@NotBlank(message="require customer details")
	private Customer customer;
	@NotBlank(message="require currency details")
	private Currency currency;
	@NotBlank(message="require sender bic details")
	private Bank senderBIC;
	@NotBlank(message="require receiver bic details")
	private Bank receiverBIC;
	@NotBlank(message="require receiver account number details")
	private String receiverAccountHolderNumber;
	@NotBlank(message="require receiver account holder name details")
	private String receiverAccountHolderName;
	@NotBlank(message="require transfer type details")
	private TransferType transferType;
	private Message message;
	@NotBlank(message="require currency amount details")
	private double currencyAmount;
	@NotBlank(message="require trasfer fee details")
	private double transferFee;
	@NotBlank(message="require inr amount details")
	private double inrAmount;
	@NotBlank(message="require transfer date details")
	private LocalDate transferDate;

}
