package com.example.springboot.thymeleafdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springboot.thymeleafdemo.entity.Employee;
import com.example.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/list")
	public String listEmployees(Model model) {
		model.addAttribute("employees", employeeService.findAll());
		
		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Employee employee = new Employee();
		
		model.addAttribute("employee", employee);
		
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.save(employee);
		
		// Redirect user to prevent duplicate submission (post-redirect-get pattern)
		return "redirect:/employees/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int employeeId, Model model) {
		Employee employee = employeeService.findById(employeeId);
		
		model.addAttribute("employee", employee);
	
		// Note that we're using the same form for adding and updating employees
		return "employees/employee-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int employeeId) {
		employeeService.deleteById(employeeId);
		
		return "redirect:/employees/list";
	}

}
