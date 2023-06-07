package com.cognizant.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Department;
import com.cognizant.model.Employee;

@Repository
public class DepartmentDao {
	
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
	private static List<Department> depList;

	public DepartmentDao() {
		depList= (List<Department>) ctx.getBean("departmentList");
	}
	
	public List<Department> getAllDepartment(){
		return depList;
	}

}
