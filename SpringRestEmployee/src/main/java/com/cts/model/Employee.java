package com.cts.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

@Entity
public class Employee {
	@Id
	private int empID;
	private String name;
//	@JsonSerialize(using = LocalDateSerializer.class)
//	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MMM-yyyy")
	private LocalDate dob;
	private String domain;
	
	public Employee() {
		super();
	}
	
	public Employee(int empID, String name, LocalDate dob, String domain) {
		super();
		this.empID = empID;
		this.name = name;
		this.dob = dob;
		this.domain = domain;
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", name=" + name + ", dob=" + dob + ", domain=" + domain + "]";
	}
	
	

}
