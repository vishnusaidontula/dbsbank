package com.dbs.payment.service;

import java.util.List;

import com.dbs.payment.exception.CustomerNotFoundException;
import com.dbs.payment.model.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();
	public Customer getCustomerById(int id) throws CustomerNotFoundException;
	public String saveCustomer(Customer customer);
	public String deleteCustomerById(int id) throws CustomerNotFoundException;
}
