package com.cognizant.moviecruiser.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int id;
	
	private String name;
	
	@OneToOne( cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	private Favourite favourite;
	
}
