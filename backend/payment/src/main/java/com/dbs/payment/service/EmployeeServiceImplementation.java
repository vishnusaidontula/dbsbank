package com.dbs.payment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.dbs.payment.dao.EmployeeRepository;
import com.dbs.payment.model.Employee;

public class EmployeeServiceImplementation implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employees = new ArrayList<Employee>();
        this.employeeRepository.findAll().forEach(emp->employees.add(emp));
        return employees;
	}

	@Override
	public Optional<Employee> getEmployeeById(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> employee = this.employeeRepository.findById(id);
        System.out.println(employee);
        return employee;
	}

	@Override
	public String saveEmployee(Employee employee) {
		if(this.employeeRepository.findById(employee.getEmployeeId()).isPresent()) {
			return "Already Exists";
		}
		try {
			this.employeeRepository.save(employee);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "Inserted";
	}

	@Override
	public String deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		try{
			this.employeeRepository.deleteById(id);
		}catch (Exception e) {
			System.out.println("Error Deleting product in database");
			throw new IllegalArgumentException("Could not delete");
		}
		return "Deleted";
	}

}
