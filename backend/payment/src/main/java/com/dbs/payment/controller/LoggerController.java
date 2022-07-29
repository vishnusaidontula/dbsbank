package com.dbs.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.payment.dto.CustomerDTO;
import com.dbs.payment.dto.EmployeeDTO;
import com.dbs.payment.dto.LoggerDTO;
import com.dbs.payment.exception.CustomerNotFoundException;
import com.dbs.payment.exception.EmployeeNotFoundException;
import com.dbs.payment.exception.LoggerNotFoundException;
import com.dbs.payment.service.CustomerService;
import com.dbs.payment.service.EmployeeService;
import com.dbs.payment.service.LoggerService;

@RestController
public class LoggerController {
	
	@Autowired
	private LoggerService loggerService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/loggers/{id}")
	public ResponseEntity<LoggerDTO> getLoggerById(@PathVariable int id) throws LoggerNotFoundException{
		LoggerDTO logger = loggerService.getLoggerById(id);
		return ResponseEntity.ok(logger);
	}
	
	@GetMapping("/customer/{id}/loggers")
	public ResponseEntity<List<LoggerDTO>> getLoggersByCustomerId(@PathVariable int id) throws CustomerNotFoundException{
		CustomerDTO customerDTO = customerService.getCustomerById(id);
		return ResponseEntity.ok(loggerService.getLoggersByCustomer(customerDTO));
	}
	@GetMapping("/employee/{id}/loggers")
	public ResponseEntity<List<LoggerDTO>> getLoggersByEmployeeId(@PathVariable int id) throws  EmployeeNotFoundException{
		EmployeeDTO  employeeDTO = employeeService.getEmployeeById(id);
		return ResponseEntity.ok(loggerService.getLoggersByEmployee(employeeDTO));
	}
	
	@PostMapping("/logger")
	public ResponseEntity<String> saveLogger(@RequestBody LoggerDTO loggerDTO){
		String response = loggerService.saveLogger(loggerDTO);
		return ResponseEntity.ok(response);
	}
}
