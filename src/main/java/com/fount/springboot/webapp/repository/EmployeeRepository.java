package com.fount.springboot.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fount.springboot.webapp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
