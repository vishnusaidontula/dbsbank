package com.dbs.payment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.payment.dao.CustomerRepository;
import com.dbs.payment.model.Customer;

@Service
public class CustomerServiceImplementation implements CustomerService{
	@Autowired
	private CustomerRepository customerRepository;
	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

}
