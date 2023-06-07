package com.cognizant.moviecruiser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.exception.FavouritesEmptyException;
import com.cognizant.moviecruiser.exception.MovieNotFound;
import com.cognizant.moviecruiser.exception.UserNotFoundException;
import com.cognizant.moviecruiser.model.Favourites;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private MovieService movieService;
	

	@GetMapping("/admin")
	public List<Movie> getAllMovies() {
		return movieService.getAllMovies();
	}

//MovieNotFound Exceptions left

	@GetMapping("/admin/{movieId}")
	public Movie getMovieById(@PathVariable long movieId) throws MovieNotFound {
		return movieService.getMovieById(movieId);
	}

	@PostMapping("/admin")
	public List<Movie> addMovie(@RequestBody Movie movie) {
		movieService.addMovie(movie);
		return movieService.getAllMovies();
	}

//MovieNotFound Exceptions left
	@PutMapping("/admin")
	public List<Movie> updateMovie(@RequestBody Movie movie) throws FavouritesEmptyException, MovieNotFound {
		movieService.updateMovie(movie);
		return movieService.getAllMovies();
	}
	
	@DeleteMapping("/admin/{movieId}")
	public List<Movie> deleteMovie(@PathVariable long movieId) throws MovieNotFound {
		movieService.deleteMovie(movieId);
		return movieService.getAllMovies();
	}
	
	@GetMapping
	public List<Movie> getAllMoviesCustomer() {
		return movieService.getAllMoviesCustomer();
	}
	
	@PostMapping("/{userId}/{movieId}")
	public Favourites addFavourite(@PathVariable String userId, @PathVariable long movieId ) throws FavouritesEmptyException, UserNotFoundException {
		movieService.addFavourite(userId,movieId);
		return movieService.getFavourites(userId);
	}
	
	@GetMapping("/{userId}")
	public Favourites getFavouritesList(@PathVariable String userId) throws FavouritesEmptyException, UserNotFoundException {
		return movieService.getFavourites(userId);
	}
	
	@DeleteMapping("/{userId}/{movieId}")
	public Favourites deleteFromFavourite(@PathVariable String userId, @PathVariable long movieId) throws MovieNotFound, FavouritesEmptyException, UserNotFoundException {
		movieService.deleteFromFavourite(userId,movieId);
		return movieService.getFavourites(userId);
	}

}
