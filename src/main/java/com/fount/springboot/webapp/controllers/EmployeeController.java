package com.fount.springboot.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fount.springboot.webapp.model.Employee;
import com.fount.springboot.webapp.service.EmployeeServiceImp;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeServiceImp employeeServiceImp;

	@GetMapping("/")
	public String home(Model model) {

		model.addAttribute("employees", employeeServiceImp.loadEmployee());
		return "index";
	}
	
	@GetMapping("/showEmployeeForm")
	public String employeeForm(Model model) {

		Employee employee= new  Employee();
		model.addAttribute("employee", employee);
		
		return "add-employee-form";
		
	}
	@PostMapping("/saveEmployee")
	public String addEmployee(@ModelAttribute("employee") Employee employee) {
		
		
		employeeServiceImp.addEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/showUpdateForm/{id}")
	public String updateForm(@PathVariable(value = "id") Long id, Model model) {
		
		Employee employee = employeeServiceImp.getEmployeeById(id);
		
		model.addAttribute("employee", employee);
		
		return "update-employee";  	
		
	} 
	
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") Long id, Model model) {
		
		this.employeeServiceImp.deleteEmployee(id);
		
		return "redirect:/";  
		
		
	} 
}
