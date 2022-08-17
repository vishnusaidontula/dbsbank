package com.dbs.payment.dao;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.payment.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, BigInteger> {
	Optional<Employee> findByEmployeeNameAndPassword(String name,String password);
}
