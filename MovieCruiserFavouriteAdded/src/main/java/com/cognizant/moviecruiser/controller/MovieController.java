package com.cognizant.moviecruiser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.model.Customer;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.CustomerService;
import com.cognizant.moviecruiser.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@Autowired 
	private CustomerService customerService;

	@GetMapping("/admin")
	public List<Movie> getAllMovies() {
		return movieService.getAllMovie();
	}

	@PostMapping("/admin")
	public void addMovie(@RequestBody Movie movie) {
		movieService.addMovie(movie);
	}

	@DeleteMapping("/admin/{movieId}")
	public void deleteMovieById(@PathVariable long movieId) {
		movieService.deleteMovie(movieId);
	}

	@GetMapping("/users")
	public List<Customer> getAllCustomers() {
		return customerService.getAllUsers();
	}

	@PostMapping("/users")
	public void addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
	}

	@GetMapping("/users/{userId}")
	public Customer getCustomerById(@PathVariable int userId) {
		return customerService.getUser(userId);
	}

	@DeleteMapping("/users/{userId}/{movieId}")
	public void deleteCustomerById(@PathVariable int userId,@PathVariable long movieId) {
		customerService.deleteMovieFromFavorite(userId,movieId);
	}

	@PostMapping("/users/{userId}/{movieId}")
	public void addFavouriteToCustomer(@PathVariable int userId, @PathVariable long movieId) {
		customerService.addMovieToFavorite(userId, movieId);
	}

}
