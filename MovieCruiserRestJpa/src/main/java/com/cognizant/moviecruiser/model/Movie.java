package com.cognizant.moviecruiser.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movie {
	@Id
	private long movie_id;
	
	private String title;
	private String boxOffice;
	private boolean active;
	
	@Temporal(TemporalType.DATE)
	private Date dateOfLaunch;
	
	private String genre;
	private boolean hasTeaser;
	

}
