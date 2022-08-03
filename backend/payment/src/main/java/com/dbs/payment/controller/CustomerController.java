package com.dbs.payment.controller;

import java.math.BigInteger;
import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.payment.dto.CustomerDTO;
import com.dbs.payment.exception.CustomerNotFoundException;

import com.dbs.payment.service.CustomerService;
@CrossOrigin("*")
@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@GetMapping("/customers")
	public ResponseEntity<List<CustomerDTO>> getCustomers(){
		return ResponseEntity.ok(customerService.getCustomers());
	}
	@GetMapping("/customer/{id}")
	public  ResponseEntity<CustomerDTO> getCustomer(@PathVariable BigInteger id) throws CustomerNotFoundException {
		CustomerDTO customer = customerService.getCustomerById(id);
		
		return ResponseEntity.ok().body(customer);
	}
	@PostMapping("/customer")
	public ResponseEntity<String> saveCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
		
		String responses = customerService.saveCustomer(customerDTO);
		return new ResponseEntity<String>(responses,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/customer/{id}")
	public String deleteCustomer(@PathVariable BigInteger id) throws CustomerNotFoundException {
		String response = customerService.deleteCustomerById(id);
		return response;
	}
	
}
