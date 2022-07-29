package com.dbs.payment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.payment.dto.EmployeeDTO;
import com.dbs.payment.exception.EmployeeNotFoundException;
import com.dbs.payment.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable int id) throws EmployeeNotFoundException
	{
		return(ResponseEntity.ok().body(employeeService.getEmployeeById(id)));
	}
	
	@PostMapping("/employee")
	public String saveEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) {
		
		String responses = employeeService.saveEmployee(employeeDTO);
		return responses;
	}
	
	@DeleteMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable int id) throws EmployeeNotFoundException {
		String response = employeeService.deleteEmployeeById(id);
		return response;
	}
	
}
