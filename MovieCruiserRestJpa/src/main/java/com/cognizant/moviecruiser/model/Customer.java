package com.cognizant.moviecruiser.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
	@Id
	private int customer_id;
	private String customerName;
	@ManyToMany
	@JoinTable(name = "user_favourites", joinColumns = @JoinColumn(name = "movie_id"),inverseJoinColumns = @JoinColumn(name="customer_id"))
	private Set<Movie> favouriteList;

}
