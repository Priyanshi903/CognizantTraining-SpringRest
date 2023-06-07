package com.cognizant.springlearn;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {

	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(Country.class);
	
	@NotNull
	@Size(min=2, max=2, message="Country code should be 2 characters")
	private String code;
	private String name;

	public Country() {
		LOGGER.debug("Inside Country Constructor.");
	}

	public String getCode() {
		LOGGER.debug("getter method of code(Country Class) called.....");
		return code;
	}

	public void setCode(String code) {
		LOGGER.debug("setter method of code(Country Class) called.....");
		this.code = code;
	}

	public String getName() {
		LOGGER.debug("getter method of name(Country Class) called.....");
		return name;
	}

	public void setName(String name) {
		LOGGER.debug("setter method of name(Country Class) called.....");
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}
	
	

}
