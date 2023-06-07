package com.cognizant.employeeservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.DepartmentDao;
import com.cognizant.model.Department;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentDao departmentDao;

	public List<Department> getAllDepartments() {
		return departmentDao.getAllDepartment();
	}
	

}
