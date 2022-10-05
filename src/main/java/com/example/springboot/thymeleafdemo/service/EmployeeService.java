package com.example.springboot.thymeleafdemo.service;

import java.util.List;

import com.example.springboot.thymeleafdemo.entity.Employee;


public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findById(int employeeId);

	public void save(Employee employee);

	public void deleteById(int employeeId);
}
