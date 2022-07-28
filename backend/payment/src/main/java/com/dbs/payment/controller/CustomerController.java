package com.dbs.payment.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.payment.dto.CustomerDTO;
import com.dbs.payment.exception.CustomerNotFoundException;
import com.dbs.payment.model.Customer;
import com.dbs.payment.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/customer/{id}")
	public  ResponseEntity<CustomerDTO> getCustomer(@PathVariable int id) throws CustomerNotFoundException {
		Customer customer = customerService.getCustomerById(id);
		CustomerDTO customerResponse = modelMapper.map(customer, CustomerDTO.class);
		return ResponseEntity.ok().body(customerResponse);
	}
	@PostMapping("/customer")
	public String saveCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
		Customer customer = modelMapper.map(customerDTO, Customer.class);
		String responses = customerService.saveCustomer(customer);
		return responses;
	}
	
	@DeleteMapping("/customer/{id}")
	public String deleteCustomer(@PathVariable int id) throws CustomerNotFoundException {
		String response = customerService.deleteCustomerById(id);
		return response;
	}
	
}
