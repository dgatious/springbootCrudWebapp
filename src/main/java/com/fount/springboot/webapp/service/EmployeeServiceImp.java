package com.fount.springboot.webapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fount.springboot.webapp.model.Employee;
import com.fount.springboot.webapp.repository.EmployeeRepository;

@Repository
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> loadEmployee() {

		List<Employee> employees = employeeRepository.findAll();

		return employees;
	}

	@Override
	public void addEmployee(Employee employee) {

		employeeRepository.save(employee);

	}

	@Override
	public Employee getEmployeeById(Long id) {

		Optional<Employee> optional = employeeRepository.findById(id);

		Employee employee = null;

		if (optional.isPresent()) {

			employee = optional.get();
		} else {

			throw new RuntimeException("Employee not found by Id" + id);
		}

		return employee;
	}

	@Override
	public void deleteEmployee(Long id) {

		this.employeeRepository.deleteById(id);

	}

}
