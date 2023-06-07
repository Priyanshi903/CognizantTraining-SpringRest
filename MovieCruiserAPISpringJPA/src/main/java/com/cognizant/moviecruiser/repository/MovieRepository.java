package com.cognizant.moviecruiser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.moviecruiser.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
