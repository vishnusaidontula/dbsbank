package com.dbs.payment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.payment.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
