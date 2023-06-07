package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.EmployeeJpaRepository;
import com.cts.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeJpaRepository employeeJpaRepository;
	
	public List<Employee> getAllEmployee(){
		return employeeJpaRepository.findAll();
	}
	
	public Employee getEmployeeById(int empid) {
		return employeeJpaRepository.findById(empid).get();
	}
	
	public void addEmployee(Employee employee) {
		employeeJpaRepository.saveAndFlush(employee);
	}
	
	public List<Employee> deleteEmployee(int empid){
		employeeJpaRepository.deleteById(empid);
		return employeeJpaRepository.findAll();
	}
	
	public List<Employee> updateEmployee(int empid,Employee e){
		Employee employee=getEmployeeById(empid);
		
		if(employee!=null) {
			e.setEmpID(empid);
			employeeJpaRepository.saveAndFlush(e);
		}
		return employeeJpaRepository.findAll();
	}
}
