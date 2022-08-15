package com.dbs.payment.service;

import java.util.List;

import com.dbs.payment.dto.CustomerDTO;
import com.dbs.payment.dto.TransactionDTO;
import com.dbs.payment.exception.CustomerNotFoundException;
import com.dbs.payment.exception.InsufficientBalanaceException;
import com.dbs.payment.exception.TransactionNotFoundException;


public interface TransactionService {
	public TransactionDTO getTransactionById(int id) throws TransactionNotFoundException;
	public List<TransactionDTO> getCustomerTransactions(CustomerDTO customerDTO);
	public TransactionDTO saveTransaction(TransactionDTO transactionDTO) throws InsufficientBalanaceException, CustomerNotFoundException;
}
