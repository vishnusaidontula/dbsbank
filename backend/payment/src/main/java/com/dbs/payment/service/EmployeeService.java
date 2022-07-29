package com.dbs.payment.service;

import java.util.List;

import com.dbs.payment.dto.EmployeeDTO;
import com.dbs.payment.exception.EmployeeNotFoundException;


public interface EmployeeService {
	public List<EmployeeDTO> getEmployees();
	public EmployeeDTO getEmployeeById(int id) throws EmployeeNotFoundException;
	public String saveEmployee(EmployeeDTO employeeDTO);
	public String deleteEmployeeById(int id) throws EmployeeNotFoundException;
}
