package com.cognizant.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.EmployeeManagementApplication;
import com.cognizant.exception.EmployeeNotFoundException;
import com.cognizant.model.Employee;

@Repository
public class EmployeeDao {
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
	private static List<Employee> empList;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeManagementApplication.class);

	public EmployeeDao() {
		empList = (List<Employee>) ctx.getBean("employeeList");
	}

	public List<Employee> getAllEmployee() {
		return empList;
	}
	
	public Employee getEmployeeById(int id) {
		return getAllEmployee().stream().filter(e->e.getId()==id).findAny().orElse(null);
	}

	public void addEmployee(Employee employee) {
		empList.add(employee);
		
	}
	
	public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
		Employee emp=getEmployeeById(employee.getId());
		LOGGER.debug("id:{}",employee.getId());
		LOGGER.info("Old Emp:{}",emp);
		
		int index = empList.indexOf(emp);
		LOGGER.debug("Index:{}",index);
		if(emp!=null)
			empList.set(index, employee);
		else
			throw new EmployeeNotFoundException();
	}

	public void deleteEmployeeByID(int id) {
		empList.remove(getEmployeeById(id));
	}
}
