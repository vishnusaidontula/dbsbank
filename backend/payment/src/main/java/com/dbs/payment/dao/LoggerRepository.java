package com.dbs.payment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.payment.model.Customer;
import com.dbs.payment.model.Logger;

public interface LoggerRepository extends JpaRepository<Logger, Integer>{
	
	public List<Logger> findByCustomer(Customer customer);

}
