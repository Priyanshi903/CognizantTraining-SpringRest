package com.cognizant.moviecruiser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.model.User;
import com.cognizant.moviecruiser.service.MovieService;
import com.cognizant.moviecruiser.service.UserService;

//@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/movies")
	public List<Movie> getAllMovies() {
		return movieService.getAllMovie();
	}
	
	@PostMapping("/movies")
	public void addMovie(@RequestBody Movie movie) {
		movieService.addMovie(movie);
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable long userId){
		return userService.getUser(userId);
	}
	
	@PostMapping("/users")
	public void addUser(@RequestBody User user){
		userService.addUser(user);
	}
	
//	@PostMapping("/users/{userId}/{movieId}")
//	public void addMovieToFavorite(@PathVariable int userId,@PathVariable long movieId){
//		
//		User user = userService.getUser(userId);
//		user.getFavouriteList().add(movieService.getMovieById(movieId));
//		userService.addUser(user);
//		
//	}
	
}
