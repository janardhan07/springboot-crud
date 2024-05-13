package com.javaspringboot.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaspringboot.crud.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
}
