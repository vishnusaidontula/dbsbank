package com.dbs.payment.controller;

import java.math.BigInteger;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.payment.dto.CustomerDTO;
import com.dbs.payment.dto.TransactionDTO;
import com.dbs.payment.exception.CustomerNotFoundException;
import com.dbs.payment.exception.InsufficientBalanaceException;
import com.dbs.payment.exception.TransactionNotFoundException;
import com.dbs.payment.service.CustomerService;
import com.dbs.payment.service.TransactionService;
@CrossOrigin("*")
@RestController
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("transaction/{id}")
	public ResponseEntity<TransactionDTO> getTransactionById(@PathVariable int id) throws TransactionNotFoundException{
		return ResponseEntity.ok(transactionService.getTransactionById(id));
	}
	@GetMapping("/transaction/customer/{id}")
	public ResponseEntity<List<TransactionDTO>> getCustomerTransactions(@PathVariable BigInteger id) throws CustomerNotFoundException{
		CustomerDTO customerDTO = customerService.getCustomerById(id);
		return ResponseEntity.ok(transactionService.getCustomerTransactions(customerDTO));
	}
	@PostMapping("/transaction")
	public ResponseEntity<TransactionDTO> saveTransaction(@RequestBody @Valid TransactionDTO transactionDTO) throws InsufficientBalanaceException, CustomerNotFoundException{
		TransactionDTO response = transactionService.saveTransaction(transactionDTO);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
}
