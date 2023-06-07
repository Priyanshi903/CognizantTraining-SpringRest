package com.cognizant.moviecruiser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.model.Customer;
import com.cognizant.moviecruiser.model.Favourite;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.repository.CustomerRepository;

@Service
public class CustomerService {

	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private MovieService movieService;
	
	public void addCustomer(Customer customer) {
		if(customer.getFavourite()==null)
			customer.setFavourite(new Favourite());
		customerRepository.saveAndFlush(customer);
	}
	
	public List<Customer> getAllUsers() {
		return customerRepository.findAll();
	}
	
	public Customer getUser(int userId) {
		return customerRepository.findById(userId).get();
	}
	
	public List<Movie> getMoviesForCustomer() {
		return movieService.getMoviesForCustomer();
	}

	public void addMovieToFavorite(int customerId, long movieId) {
		Customer customer=getUser(customerId);
		customer.getFavourite().getMovieList().add(movieService.getMovieById(movieId));
		customer.getFavourite().setNoOfFavourites(customer.getFavourite().getMovieList().size());
		customerRepository.save(customer);
	}

	public void deleteMovieFromFavorite(int customerId, long movieId) {
		Customer customer=getUser(customerId);
		int index=customer.getFavourite().getMovieList().indexOf(movieService.getMovieById(movieId));
		customer.getFavourite().getMovieList().remove(index);
		customer.getFavourite().setNoOfFavourites(customer.getFavourite().getMovieList().size());
		customerRepository.save(customer);
	}

}
