package com.cognizant.moviecruiser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.model.User;
import com.cognizant.moviecruiser.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public void addUser(User user) {
		userRepository.saveAndFlush(user);
	}
	
	public User getUser(long userId) {
		return userRepository.findById(userId).get();
	}
	
	
}
