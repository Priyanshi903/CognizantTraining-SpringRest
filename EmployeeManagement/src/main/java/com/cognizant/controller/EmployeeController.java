package com.cognizant.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.employeeservice.EmployeeService;
import com.cognizant.exception.EmployeeNotFoundException;
import com.cognizant.model.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeByID(@PathVariable int id) {
		return employeeService.getEmployeeByID(id);
	}
	
	@PostMapping()
	public void addEmployee(@RequestBody @Valid Employee employee) {
		employeeService.addEmployee(employee);
	}
	
	@PutMapping
	public void updateEmployee(@RequestBody Employee employee) throws EmployeeNotFoundException {
		employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployeeByID(@PathVariable int id) {
		employeeService.deleteEmployeeByID(id);
	}
}
