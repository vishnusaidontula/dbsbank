package com.dbs.payment.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.payment.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, BigInteger> {

}
