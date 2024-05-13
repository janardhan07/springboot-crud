package com.javaspringboot.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaspringboot.crud.Entity.Employee;
import com.javaspringboot.crud.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return ResponseEntity.ok().body(employeeService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Employee> insertEmployee(@RequestBody Employee Employee) {
		return ResponseEntity.ok().body(employeeService.saveEmployee(Employee));
	}

	@PutMapping
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee Employee) {
        return ResponseEntity.ok().body(employeeService.updateEmployee(Employee));
    }
	
	@DeleteMapping
	public ResponseEntity<String> deleteProduct(@RequestParam(name="EmployeeId", value="EmployeeId") long id) {
        return ResponseEntity.ok().body(employeeService.deleteEmployee(id));
    }
}
