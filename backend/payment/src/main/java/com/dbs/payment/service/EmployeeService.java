package com.dbs.payment.service;

import java.math.BigInteger;
import java.util.List;

import com.dbs.payment.dto.EmployeeDTO;
import com.dbs.payment.exception.EmployeeNotFoundException;


public interface EmployeeService {
	public List<EmployeeDTO> getEmployees();
	public EmployeeDTO getEmployeeById(BigInteger id) throws EmployeeNotFoundException;
	public EmployeeDTO getEmployeeByNameAndPassword(String name,String password) throws EmployeeNotFoundException;
	public String saveEmployee(EmployeeDTO employeeDTO);
	public String deleteEmployeeById(BigInteger id) throws EmployeeNotFoundException;
}
