package com.cognizant.MovieCruiserRestJpa;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan("com.*")
public class MovieCruiserRestJpaApplication {

	public static void main(String[] args) {
		 SpringApplication.run(MovieCruiserRestJpaApplication.class, args);
		
	}

}
