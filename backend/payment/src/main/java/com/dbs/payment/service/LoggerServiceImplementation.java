package com.dbs.payment.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.payment.dao.LoggerRepository;
import com.dbs.payment.dto.CustomerDTO;
import com.dbs.payment.dto.LoggerDTO;
import com.dbs.payment.exception.LoggerNotFoundException;
import com.dbs.payment.model.Customer;
import com.dbs.payment.model.Logger;

@Service
public class LoggerServiceImplementation implements LoggerService{
	
	@Autowired
	private LoggerRepository loggerRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public LoggerDTO getLoggerById(int id) throws LoggerNotFoundException {
		Optional<Logger> response = loggerRepository.findById(id);
		if(response.isEmpty())
			throw new LoggerNotFoundException("Invalid logger id - "+id);
		LoggerDTO loggerDTO = modelMapper.map(response.get(), LoggerDTO.class);
		return loggerDTO;
	}

	@Override
	public List<LoggerDTO> getLoggersByCustomer(CustomerDTO customerDTO) {
		Customer customer = modelMapper.map(customerDTO, Customer.class);
		return loggerRepository.findByCustomer(customer).stream()
				.map(logger->modelMapper.map(logger, LoggerDTO.class))
				.collect(Collectors.toList());
	}

	

	@Override
	public String saveLogger(LoggerDTO loggerDTO) {
		Logger logger = modelMapper.map(loggerDTO, Logger.class);
		loggerRepository.save(logger);
		return "successfully added";
	}

	@Override
	public List<LoggerDTO> getLoggers() {
		// TODO Auto-generated method stub
		return loggerRepository.findAll().stream()
				.map(logger->modelMapper.map(logger, LoggerDTO.class))
				.collect(Collectors.toList());
	}

	

	

}
