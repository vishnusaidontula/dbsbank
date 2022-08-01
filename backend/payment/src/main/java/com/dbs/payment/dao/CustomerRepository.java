package com.dbs.payment.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.payment.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, BigInteger>{

}
