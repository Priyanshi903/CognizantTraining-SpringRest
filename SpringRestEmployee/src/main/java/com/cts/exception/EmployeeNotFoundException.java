package com.cts.exception;

public class EmployeeNotFoundException extends Exception {
	public EmployeeNotFoundException() {

	}

	public EmployeeNotFoundException(String mssg) {
		super(mssg);
	}

}
