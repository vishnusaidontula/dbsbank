package com.dbs.payment.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.payment.dao.EmployeeRepository;
import com.dbs.payment.dto.EmployeeDTO;
import com.dbs.payment.exception.EmployeeNotFoundException;
import com.dbs.payment.model.Employee;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public List<EmployeeDTO> getEmployees() {
		return employeeRepository.findAll().stream()
				.map(employee -> modelMapper.map(employee, EmployeeDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDTO getEmployeeById(BigInteger id) throws EmployeeNotFoundException {
		Optional<Employee> employee = this.employeeRepository.findById(id);
        if(employee.isEmpty())
        {
        	throw new EmployeeNotFoundException("Invalid Employee Id "+id);
        }
        return modelMapper.map(employee.get(), EmployeeDTO.class);
	}

	@Override
	public String saveEmployee(EmployeeDTO employeeDTO) {
		Employee employee=modelMapper.map(employeeDTO,Employee.class);
		employeeRepository.save(employee);
		return "sucessfully saved employee details";
	}

	@Override
	public String deleteEmployeeById(BigInteger id) throws EmployeeNotFoundException {
		EmployeeDTO employeeDTO=getEmployeeById(id);
		Employee employee=modelMapper.map(employeeDTO, Employee.class);
		employeeRepository.delete(employee);
		return "sucessfully deleted employee with id - "+id;
	}

	@Override
	public EmployeeDTO getEmployeeByNameAndPassword(String name, String password) throws EmployeeNotFoundException {
		Optional<Employee> employee = this.employeeRepository.findByEmployeeNameAndPassword(name,password);
        if(employee.isEmpty())
        {
        	throw new EmployeeNotFoundException("Invalid Employee Details");
        }
        return modelMapper.map(employee.get(), EmployeeDTO.class);
	}

}
