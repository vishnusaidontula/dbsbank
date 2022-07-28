package com.dbs.payment.service;

import java.util.List;
import java.util.Optional;

import com.dbs.payment.model.Employee;

public interface EmployeeService {
	public List<Employee> getEmployees();
	public Optional<Employee> getEmployeeById(int id);
	public String saveEmployee(Employee employee);
	public String deleteEmployeeById(int id);
}
