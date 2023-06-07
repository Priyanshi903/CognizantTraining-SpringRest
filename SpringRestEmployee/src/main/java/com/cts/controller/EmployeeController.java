package com.cts.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cts.dao.EmployeeRepository;
import com.cts.exception.EmployeeNotFoundException;
import com.cts.model.Employee;
import com.cts.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	
//	@Autowired
//	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> getAll(){
		return employeeService.getAllEmployee();
//		return employeeRepository.getAllEmployees();
	}
	
	/*
	 * @GetMapping("/{empid}") public ResponseEntity<Employee>
	 * getEmployee(@PathVariable int empid) { Employee
	 * employee=employeeRepository.getEmployeeByID(empid); if (employee!=null)
	 * return new ResponseEntity<Employee>(employee,HttpStatus.FOUND); else return
	 * new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	 * 
	 * }
	 */
	
	@GetMapping("/{empid}")
	public Employee getEmployee(@PathVariable int empid) throws EmployeeNotFoundException {
;
		
		Employee employee=null;
		try {
//			employee=employeeRepository.getEmployeeByID(empid);
			employee=employeeService.getEmployeeById(empid);
			
		} catch (Exception e) {
			throw new EmployeeNotFoundException("Employee with id:"+empid+" not registered");
		}
		
		return employee;
	}
	
	@DeleteMapping("/{empid}")
	public List<Employee> deleteEmployee(@PathVariable int empid){
		return employeeService.deleteEmployee(empid);
//		employeeRepository.deleteEmployee(empid);
//		return employeeRepository.getAllEmployees();
	}
	
	@PostMapping
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		/*
		 * { "name": "Priya cts", "dob": "1999-03-09", "domain": "bigdata" }
		 */
		employee.setEmpID(100+employeeService.getAllEmployee().size());
//		employee.setEmpID(101+employeeRepository.getAllEmployees().size());
		System.out.println(employee);
		employeeService.addEmployee(employee);
//		employeeRepository.addEmployee(employee);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{empid}").buildAndExpand(employee.getEmpID()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/{empid}")
	public List<Employee> updateEmployee(@PathVariable int empid,@RequestBody Employee newEmployee) throws EmployeeNotFoundException {
		try {
//			employee=employeeRepository.getEmployeeByID(empid);
			
			employeeService.updateEmployee(empid,newEmployee);
			
		} catch (Exception e) {
			throw new EmployeeNotFoundException("Employee with id:"+empid+" not registered");
		}
		return employeeService.getAllEmployee();
//		return employeeService.getEmployeeById(empid);
//		employeeRepository.updateEmployee(empid,newEmployee);
//		return employeeRepository.getEmployeeByID(empid);
	}

}
