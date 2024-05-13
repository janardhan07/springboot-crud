package com.javaspringboot.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaspringboot.crud.Entity.Employee;
import com.javaspringboot.crud.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Optional<Employee> findById(long id) {
		return employeeRepository.findById(id);
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Optional<Employee> employeeData = employeeRepository.findById(employee.getId());
		if(employeeData.isPresent()) {
			Employee existEmployee = employeeData.get();
			existEmployee.setFirstName(employee.getFirstName());
			existEmployee.setLastName(employee.getLastName());
			existEmployee.setEmail(employee.getEmail());
			return employeeRepository.save(existEmployee);
		}
		return null;
	}

	@Override
	public String deleteEmployee(long id) {
		Optional<Employee> existEmp = employeeRepository.findById(id);
		if (existEmp.isPresent()) {
			employeeRepository.delete(existEmp.get());
			return "Employee deleted successfully";
		}
		return "Not Found!";
	}

}
