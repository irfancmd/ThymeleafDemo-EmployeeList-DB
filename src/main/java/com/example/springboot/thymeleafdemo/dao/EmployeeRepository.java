package com.example.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.thymeleafdemo.entity.Employee;

/*
 * This is the Spring Data JPA implementation of the Employee DAO.
 * It will automatically provide us with the all the necessary CRUD methods by its own
 * */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	// No implementation needed for basic CRUD methods
	
	// Here, Spring Data JPA will automatically parse the method name and create the desired
	// query for us
	public List<Employee> findAllByOrderByLastNameAsc();
}
