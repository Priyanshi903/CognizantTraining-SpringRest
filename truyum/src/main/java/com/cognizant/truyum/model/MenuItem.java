package com.cognizant.truyum.model;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItem {
	
	@NotNull(message = "MenuItem Id cannot be null")
	private long id;
	
	@Size(min = 1,max = 30,message = "Size should be between 1 to 30")
	@NotBlank(message = "MenuItem Name cant be blank")
	private String name;
	
	@NotNull(message = "Price cannot be null")
	@Min(value = 0,message = "Minimum price allowed is 0")
	private float price;
	
	@NotNull(message = "Enter value for active(true/false)")
	private boolean active;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy",timezone="IST")
	private Date dateOfLaunch;
	
	private String category;
	private boolean freeDelivery;
}
