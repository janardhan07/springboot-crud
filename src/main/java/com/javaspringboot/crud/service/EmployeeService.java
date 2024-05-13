package com.javaspringboot.crud.service;

import java.util.List;
import java.util.Optional;

import com.javaspringboot.crud.Entity.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	Optional<Employee> findById(long id);
	List<Employee> findAll();
	Employee updateEmployee(Employee employee);
	String deleteEmployee(long id);
}
