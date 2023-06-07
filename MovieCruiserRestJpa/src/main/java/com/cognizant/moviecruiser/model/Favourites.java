package com.cognizant.moviecruiser.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Favourites {
	@Id
	private int favouriteId;
	@OneToMany
	private List<Movie> movieList;
	private long noOfFavorites;

}
