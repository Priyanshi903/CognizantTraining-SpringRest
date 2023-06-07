package com.cognizant.moviecruiser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
//	@GetMapping("/")
//	public List<Movie> getAllMovies() {
//		return movieService.getAllMovie();
//	}
//	
//	@PostMapping("/")
//	public void addMovie(@RequestBody Movie movie) {
//		movieService.addMovie(movie);
//	}
//	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getUser(@PathVariable long customerId){
		return customerService.getCustomer(customerId);
	}
	
	@PostMapping("/customers")
	public void addUser(@RequestBody Customer customer){
		customerService.addCustomer(customer);
	}
	
	@PostMapping("/customers/{customerId}/{movieId}")
	public void addMovieToFavorite(@PathVariable int customerId,@PathVariable long movieId){
		customerService.addMovieToFavorite(customerId, movieId);
	}
	
}
