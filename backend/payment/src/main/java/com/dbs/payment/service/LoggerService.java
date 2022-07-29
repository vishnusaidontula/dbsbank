package com.dbs.payment.service;

import java.util.List;

import com.dbs.payment.dto.CustomerDTO;
import com.dbs.payment.dto.EmployeeDTO;
import com.dbs.payment.dto.LoggerDTO;
import com.dbs.payment.exception.LoggerNotFoundException;


public interface LoggerService {
	public LoggerDTO getLoggerById(int id) throws LoggerNotFoundException;
	public List<LoggerDTO> getLoggersByCustomer(CustomerDTO customerDTO);
	public List<LoggerDTO> getLoggersByEmployee(EmployeeDTO employeeDTO);
	public String saveLogger(LoggerDTO loggerDTO);
}
