package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Employee;
import com.example.demo.Repository.EmployeeRepository;

import lombok.Data;
@Data
@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Optional<Employee> getEmployee (Integer id) {
	 return	employeeRepository.findById(id);
	}
	
	public Iterable<Employee> getEmployees() {
		return employeeRepository.findAll();
	}
	
	public void deleteEmployee (Integer id) {
		employeeRepository.deleteById(id);
	}
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
}
