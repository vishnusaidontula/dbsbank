package com.dbs.payment.dto;

import java.time.LocalDate;

import com.dbs.payment.model.Bank;
import com.dbs.payment.model.Currency;
import com.dbs.payment.model.Customer;
import com.dbs.payment.model.Message;
import com.dbs.payment.model.TransferType;

import lombok.Data;

@Data
public class TransactionDTO {
	private int transactionId;
	private Customer customer;
	private Currency currency;
	private Bank senderBIC;
	private Bank receiverBIC;
	private String receiverAccountHolderNumber;
	private String receiverAccountHolderName;
	private TransferType transferType;
	private Message message;
	private double currencyAmount;
	private double transferFee;
	private double inrAmount;
	private LocalDate transferDate;

}
