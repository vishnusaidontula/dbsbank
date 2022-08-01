package com.dbs.payment.service;

import java.math.BigInteger;
import java.util.List;

import com.dbs.payment.dto.CustomerDTO;
import com.dbs.payment.exception.CustomerNotFoundException;

public interface CustomerService {
	public List<CustomerDTO> getCustomers();
	public CustomerDTO getCustomerById(BigInteger id) throws CustomerNotFoundException;
	public String saveCustomer(CustomerDTO customerDTO);
	public String deleteCustomerById(BigInteger id) throws CustomerNotFoundException;
}
