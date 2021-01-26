package com.fount.springboot.webapp.service;

import java.util.List;

import com.fount.springboot.webapp.model.Employee;

public interface EmployeeService {

	List<Employee> loadEmployee();
	
	void addEmployee(Employee employee);
	
	 Employee getEmployeeById(Long id);

	 void deleteEmployee(Long id);
	
}
