package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
