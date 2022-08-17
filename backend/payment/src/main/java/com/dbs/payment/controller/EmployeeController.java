package com.dbs.payment.controller;

import java.math.BigInteger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.payment.dto.EmployeeDTO;
import com.dbs.payment.exception.EmployeeNotFoundException;
import com.dbs.payment.service.EmployeeService;
@CrossOrigin("*")
@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable BigInteger id) throws EmployeeNotFoundException
	{
		return(ResponseEntity.ok().body(employeeService.getEmployeeById(id)));
	}
	@PostMapping("/checkemployee")
	public ResponseEntity<EmployeeDTO> getEmployeeByNameAndPassword(@RequestBody EmployeeDTO employee) throws EmployeeNotFoundException
	{
		return(ResponseEntity.ok().body(employeeService.getEmployeeByNameAndPassword(employee.getEmployeeName(),employee.getPassword())));
	}
	@PostMapping("/employee")
	public ResponseEntity<String> saveEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) {
		
		String responses = employeeService.saveEmployee(employeeDTO);
		return new ResponseEntity<>(responses,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable BigInteger id) throws EmployeeNotFoundException {
		String response = employeeService.deleteEmployeeById(id);
		return new ResponseEntity<>(response,HttpStatus.NO_CONTENT);
	}
	
}
