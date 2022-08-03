package com.dbs.payment.controller;

import java.math.BigInteger;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.payment.dto.CustomerDTO;
import com.dbs.payment.dto.LoggerDTO;
import com.dbs.payment.exception.CustomerNotFoundException;
import com.dbs.payment.exception.LoggerNotFoundException;
import com.dbs.payment.service.CustomerService;
import com.dbs.payment.service.LoggerService;
@CrossOrigin("*")
@RestController
public class LoggerController {
	
	@Autowired
	private LoggerService loggerService;
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/loggers")
	public ResponseEntity<List<LoggerDTO>> getLoggers(){
		return new ResponseEntity<>(loggerService.getLoggers(),HttpStatus.OK);
	}
	
	@GetMapping("/loggers/{id}")
	public ResponseEntity<LoggerDTO> getLoggerById(@PathVariable int id) throws LoggerNotFoundException{
		LoggerDTO logger = loggerService.getLoggerById(id);
		return new ResponseEntity<>(logger,HttpStatus.OK);
	}
	
	@GetMapping("/loggers/customer/{id}")
	public ResponseEntity<List<LoggerDTO>> getLoggersByCustomerId(@PathVariable BigInteger id) throws CustomerNotFoundException{
		CustomerDTO customerDTO = customerService.getCustomerById(id);
		return ResponseEntity.ok(loggerService.getLoggersByCustomer(customerDTO));
	}
	@PostMapping("/logger")
	public ResponseEntity<String> saveLogger(@RequestBody @Valid LoggerDTO loggerDTO){
		String response = loggerService.saveLogger(loggerDTO);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
}
