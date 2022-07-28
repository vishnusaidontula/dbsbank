package com.dbs.payment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.payment.dao.CustomerRepository;
import com.dbs.payment.exception.CustomerNotFoundException;
import com.dbs.payment.model.Customer;

@Service
public class CustomerServiceImplementation implements CustomerService{
	@Autowired
	private CustomerRepository customerRepository;
	@Override
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}
	@Override
	public Customer getCustomerById(int id) throws CustomerNotFoundException {
		Optional<Customer> res = customerRepository.findById(id);
		if(res.isEmpty())
			throw new CustomerNotFoundException("Invalid customer id - "+id);
		return res.get();
	}
	@Override
	public String saveCustomer(Customer customer) {
		customerRepository.save(customer);
		return "sucessfully saved customer details";
	}
	@Override
	public String deleteCustomerById(int id) throws CustomerNotFoundException {
		Customer customer = getCustomerById(id);
		customerRepository.delete(customer);
		return "sucessfully deleted customer with id - "+id;
	}

}
