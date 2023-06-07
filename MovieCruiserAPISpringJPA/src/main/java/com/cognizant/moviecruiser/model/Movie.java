package com.cognizant.moviecruiser.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title;
	private String boxOffice;
	private boolean active;
	
	@Temporal(TemporalType.DATE)
	private Date dateOfLaunch;
	
	private String genre;
	private boolean hasTeaser;
	@ManyToMany(mappedBy = "movies")
	private List<User> users;
}
