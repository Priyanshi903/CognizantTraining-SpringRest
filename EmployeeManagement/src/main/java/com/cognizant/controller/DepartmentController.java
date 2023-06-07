package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.employeeservice.DepartmentService;
import com.cognizant.model.Department;

//@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/departments")
	public List<Department> getAllDepartments(){
		return departmentService.getAllDepartments();
	}
}
