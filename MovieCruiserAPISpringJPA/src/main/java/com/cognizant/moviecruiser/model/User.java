package com.cognizant.moviecruiser.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//1-101,1-102

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	private String name;
	
//	@ManyToMany
//	@JoinTable(name = "user_favourites", joinColumns = @JoinColumn(name = "movie_id"),inverseJoinColumns = @JoinColumn(name="User_id"))
//	private Set<Movie> favouriteList;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="movie_id"))
	private List<Movie> movies;
	
	@OneToOne
	@JoinColumn(name="favouriteId")
	private Favourites favourites;
	
}
