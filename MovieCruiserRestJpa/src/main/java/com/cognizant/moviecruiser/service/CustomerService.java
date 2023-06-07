package com.cognizant.moviecruiser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.moviecruiser.model.Customer;
import com.cognizant.moviecruiser.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private MovieService movieService;
	
	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}
	
	public void addCustomer(Customer customer) {
		customerRepository.saveAndFlush(customer);
	}
	
	public Customer getCustomer(long userId) {
		return customerRepository.findById(userId).get();
	}
	
	public void addMovieToFavorite(int customerId,long movieId){
		Customer customer = getCustomer(customerId);
		customer.getFavouriteList().add(movieService.getMovieById(movieId));
		addCustomer(customer);
	}
	
}
