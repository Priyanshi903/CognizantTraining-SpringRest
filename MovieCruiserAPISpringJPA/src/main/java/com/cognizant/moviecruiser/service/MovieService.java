package com.cognizant.moviecruiser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	
	public List<Movie> getAllMovie(){
		return movieRepository.findAll();
	}
	
	public Movie getMovieById(long movieId) {
		return movieRepository.findById(movieId).get();
	}
	


	public void addMovie(Movie movie) {
		movieRepository.save(movie);
	}
	
	
	
}
