package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Employee;
import com.example.demo.Service.EmployeeService;

@CrossOrigin("*")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public Iterable<Employee> getEmployees(){
		return employeeService.getEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public Optional<Employee> getEmployee (Integer id){
		return employeeService.getEmployee(id);
	}
	
	@PostMapping("/employees")
	public Employee saveEmployee(Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee (Integer id) {
		employeeService.deleteEmployee(id); 
	}
}
