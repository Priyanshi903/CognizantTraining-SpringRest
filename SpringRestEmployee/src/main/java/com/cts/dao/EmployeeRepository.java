package com.cts.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cts.model.Employee;

@Repository
public class EmployeeRepository {
	
	private static List<Employee> employees;
	
	static {
		employees=new ArrayList<Employee>();
		employees.add(new Employee(101, "Priyanshi", LocalDate.of(1999, 03, 9), "Trainee"));
		employees.add(new Employee(102, "Riya", LocalDate.of(1989, 02, 2), "HR"));
		employees.add(new Employee(103, "John", LocalDate.of(1994, 12, 11), "Lead"));
		employees.add(new Employee(104, "Alice", LocalDate.of(1969, 11, 22), "Manager"));
	}
	
	public List<Employee> getAllEmployees(){
		return employees;
	}
	
	public Employee getEmployeeByID(int id) {
//		for(Employee e:employees) {
//			if(e.getEmpID()==id) {
//				return e;
//			}
//		}
		return getAllEmployees().stream().filter(e->e.getEmpID()==id).findFirst().get();
	}
	
	public void deleteEmployee(int id) {
		Iterator<Employee> iterator=employees.iterator();
		while(iterator.hasNext()) {
			Employee employee=iterator.next();
			if(employee.getEmpID()==id) {
				iterator.remove();
				break;
			}
		}
	}
	
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}

	public void updateEmployee(int id,Employee newEmployee) {
		Employee employee=getEmployeeByID(id);
		employee.setDob(newEmployee.getDob());
		employee.setDomain(newEmployee.getDomain());
		employee.setName(newEmployee.getName());
		
	}
	
	

}
