package com.cognizant.moviecruiser.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.moviecruiser.dao.MovieDaoCollectionImpl;
import com.cognizant.moviecruiser.exception.FavouritesEmptyException;
import com.cognizant.moviecruiser.exception.MovieNotFound;
import com.cognizant.moviecruiser.exception.UserNotFoundException;
import com.cognizant.moviecruiser.model.Favourites;
import com.cognizant.moviecruiser.model.Movie;

@Service
public class MovieService {
	@Autowired
	private MovieDaoCollectionImpl movieDaoCollectionImpl;

	public List<Movie> getAllMovies() {
		return movieDaoCollectionImpl.getAllMovies();
	}

	public void addMovie(Movie movie) {
		movieDaoCollectionImpl.addMovie(movie);
	}

	public void updateMovie(Movie movie) throws MovieNotFound {
		getMovieById(movie.getId());
		movieDaoCollectionImpl.updateMovie(movie);
	}

	public Movie getMovieById(long movieId) throws MovieNotFound {
		if (movieDaoCollectionImpl.getMovieById(movieId) == null)
			throw new MovieNotFound("Movie Not Found!!!");
		return movieDaoCollectionImpl.getMovieById(movieId);
	}

	public void deleteMovie(long movieId) throws MovieNotFound {
		getMovieById(movieId);
		movieDaoCollectionImpl.deleteMovie(movieId);
	}

	public List<Movie> getAllMoviesCustomer() {
		List<Movie> movies = movieDaoCollectionImpl.getAllMovies();
		Date now = new Date();
		List<Movie> filteredList = movies.stream()
				.filter(movie -> movie.isActive() && now.compareTo(movie.getDateOfLaunch()) >= 0)
				.collect(Collectors.toList());

		return filteredList;
	}

	public void addFavourite(String userId, long movieId) {
		movieDaoCollectionImpl.addFavourite(userId, movieId);
	}

	public Favourites getFavourites(String userId) throws FavouritesEmptyException, UserNotFoundException {
		if (movieDaoCollectionImpl.getFavouritesForUser(userId) == null)
			throw new UserNotFoundException("User Not Found");
		if (movieDaoCollectionImpl.getFavouritesForUser(userId).getNoOfFavorites() == 0L)
			throw new FavouritesEmptyException("Add movies to your watchlist!!!");
		return movieDaoCollectionImpl.getFavouritesForUser(userId);
	}

	public void deleteFromFavourite(String userId, long movieId) throws MovieNotFound, FavouritesEmptyException, UserNotFoundException {
		getFavourites(userId);
		getMovieById(movieId);
		movieDaoCollectionImpl.deleteFromFavourites(userId, movieId);
	}
}
