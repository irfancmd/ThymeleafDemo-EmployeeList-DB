package com.example.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.example.springboot.thymeleafdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository emploRepository) {
		this.employeeRepository = emploRepository;
	}

	@Override
	public List<Employee> findAll() {
//		return employeeRepository.findAll();
		
		// Return all employees order by their last name in ascending manner
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int employeeId) {
		Optional<Employee> result = employeeRepository.findById(employeeId);
		
		Employee employee = null;
		
		if(result.isPresent()) {
			employee = result.get();
		}
		
		return employee;
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int employeeId) {
		employeeRepository.deleteById(employeeId);
	}

}
