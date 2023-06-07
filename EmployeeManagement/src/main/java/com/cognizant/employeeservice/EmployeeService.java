package com.cognizant.employeeservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.EmployeeDao;
import com.cognizant.exception.EmployeeNotFoundException;
import com.cognizant.model.Employee;

@Service
public class EmployeeService {

		@Autowired
		private EmployeeDao employeeDao;
		
		public List<Employee> getAllEmployees(){
			return employeeDao.getAllEmployee();
		}

		public void addEmployee(Employee employee) {
			employeeDao.addEmployee(employee);
		}

		public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
			employeeDao.updateEmployee(employee);
		}

		public Employee getEmployeeByID(int id) {
			return employeeDao.getEmployeeById(id);
		}

		public void deleteEmployeeByID(int id) {
			employeeDao.deleteEmployeeByID( id);
		}
		
}
