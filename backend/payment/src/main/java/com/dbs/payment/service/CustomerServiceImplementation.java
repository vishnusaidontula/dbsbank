package com.dbs.payment.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.payment.dao.CustomerRepository;
import com.dbs.payment.dto.CustomerDTO;
import com.dbs.payment.exception.CustomerNotFoundException;
import com.dbs.payment.model.Customer;

@Service
public class CustomerServiceImplementation implements CustomerService{
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private CustomerRepository customerRepository;
	@Override
	public List<CustomerDTO> getCustomers() {
		return customerRepository.findAll().stream().map(customer -> modelMapper.map(customer, CustomerDTO.class))
		.collect(Collectors.toList());	
	}
	@Override
	public CustomerDTO getCustomerById(BigInteger id) throws CustomerNotFoundException {
		Optional<Customer> res = customerRepository.findById(id);
		if(res.isEmpty())
			throw new CustomerNotFoundException("Invalid customer id - "+id);
		return modelMapper.map(res.get(), CustomerDTO.class);
	}
	@Override
	public String saveCustomer(CustomerDTO customerDTO) {
		Customer customer = modelMapper.map(customerDTO, Customer.class);
		customerRepository.save(customer);
		return "sucessfully saved customer details";
	}
	@Override
	public String deleteCustomerById(BigInteger id) throws CustomerNotFoundException {
		CustomerDTO customerDTO = getCustomerById(id);
		Customer customer = modelMapper.map(customerDTO, Customer.class);
		customerRepository.delete(customer);
		return "sucessfully deleted customer with id - "+id;
	}

}
