package com.dbs.payment.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.payment.dao.LoggerRepository;
import com.dbs.payment.dao.TransactionRepository;
import com.dbs.payment.dto.CustomerDTO;
import com.dbs.payment.dto.TransactionDTO;
import com.dbs.payment.exception.CustomerNotFoundException;
import com.dbs.payment.exception.InsufficientBalanaceException;
import com.dbs.payment.exception.TransactionNotFoundException;
import com.dbs.payment.model.Customer;
import com.dbs.payment.model.Logger;
import com.dbs.payment.model.Transaction;

@Service
public class TransactionServiceImplementation implements TransactionService{
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private LoggerRepository loggerRepository;

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
	public TransactionDTO saveTransaction(TransactionDTO transactionDTO) throws InsufficientBalanaceException, CustomerNotFoundException {
		Transaction transaction = modelMapper.map(transactionDTO, Transaction.class);
		CustomerDTO senderCustomer = customerService.getCustomerById(transactionDTO.getCustomer().getCustomerId());
		double updateSenderCustomerBalance = senderCustomer.getClearBalance()-transactionDTO.getInrAmount();
		if(updateSenderCustomerBalance > 0 ||  senderCustomer.isOverDraftFlag()) {
			senderCustomer.setClearBalance(updateSenderCustomerBalance);
			customerService.saveCustomer(senderCustomer);
		}
		else {
			throw new InsufficientBalanaceException("Insufficient Balance");
		}
		Logger logger = new Logger();
		logger.setCustomer(modelMapper.map(senderCustomer, Customer.class));
		logger.setTransaction(transaction);
		logger.setIpaddress("198.168.1.1");
		logger.setScreename("logger");
		logger.setAction("transaction");
		transactionRepository.save(transaction);
		loggerRepository.save(logger);
		return modelMapper.map(transaction,TransactionDTO.class);
	}

}
