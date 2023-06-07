package com.cognizant.model;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {
	@NotNull(message = "Employee Id cannot be null")
	private int id;
	
	@Size(min = 1,max = 30,message = "Size should be between 1 to 30")
	@NotBlank(message = "Employee Name cant be blank")
	private String name;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy",timezone="IST")
	private Date dateOfBirth;
	
	@Valid
	private Department department;
	
	@NotNull(message = "Enter value for permanent(true/false)")
	private boolean permanent;
	
	@NotNull(message = "Salary cannot be null")
	@Min(value = 0,message = "Minimum salary allowed is 0")
	private long salary;
	
	
}
