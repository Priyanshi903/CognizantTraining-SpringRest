package com.cognizant.moviecruiser.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Favourites {
	//id
	//onetomany
	private List<Movie> movieList;
	private long noOfFavorites;

}
