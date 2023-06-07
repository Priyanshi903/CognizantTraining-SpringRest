package com.cognizant.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Department {
	
	@NotNull(message = "Dept Id cannot be null")
	private int depId;
	
	@Size(min = 1,max = 30,message = "Size should be between 1 to 30")
	@NotBlank(message = "Department Name cant be blank")
	private String depName;

	public Department() {
		super();

	}

	public Department(int depId, String depName) {
		super();
		this.depId = depId;
		this.depName = depName;
	}

	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

}
