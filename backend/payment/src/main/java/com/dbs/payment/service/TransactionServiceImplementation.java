package com.dbs.payment.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.payment.dao.TransactionRepository;
import com.dbs.payment.dto.CustomerDTO;
import com.dbs.payment.dto.TransactionDTO;
import com.dbs.payment.exception.InsufficientBalanaceException;
import com.dbs.payment.exception.TransactionNotFoundException;
import com.dbs.payment.model.Customer;
import com.dbs.payment.model.Transaction;

@Service
public class TransactionServiceImplementation implements TransactionService{
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public TransactionDTO getTransactionById(int id) throws TransactionNotFoundException {
		Optional<Transaction> response  = transactionRepository.findById(id);
		if(response.isEmpty())
			throw new TransactionNotFoundException("Invalid transaction id - "+id);
		return modelMapper.map(response.get(), TransactionDTO.class);
	}

	@Override
	public List<TransactionDTO> getCustomerTransactions(CustomerDTO customerDTO) {
		Customer customer = modelMapper.map(customerDTO, Customer.class);
		return transactionRepository.findByCustomer(customer).stream()
				.map(transaction -> modelMapper.map(transaction, TransactionDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public String saveTransaction(TransactionDTO transactionDTO) throws InsufficientBalanaceException {
		// TODO Auto-generated method stub
		Transaction transaction = modelMapper.map(transactionDTO, Transaction.class);
		Customer customer = transactionDTO.getCustomer();
		double updateCustomerBalance = customer.getClearBalance()-transactionDTO.getInrAmount();
		if(customer.isOverDraftFlag() || updateCustomerBalance  >0) {
			customer.setClearBalance(updateCustomerBalance );
		}
		else {
			throw new InsufficientBalanaceException("Insufficient Balance");
		}
		transactionRepository.save(transaction);
		return "Successfully save transaction details";
	}

}
