package com.dbs.payment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.payment.model.Customer;
import com.dbs.payment.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
	
	public List<Transaction> findByCustomer(Customer Customer);
}
