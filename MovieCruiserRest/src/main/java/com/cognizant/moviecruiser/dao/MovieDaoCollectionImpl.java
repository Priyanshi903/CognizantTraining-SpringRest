package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cognizant.moviecruiser.model.Favourites;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;


@Repository
public class MovieDaoCollectionImpl {
	
	private static List<Movie> allMoviesList;
	
	private static Map<String,Favourites> allUserFavourites;
	
	public MovieDaoCollectionImpl() {
		allMoviesList = new ArrayList<>();
		allUserFavourites=new HashMap<>();
		allMoviesList.add(new Movie(1001L, "Avatar", "$2,787,965,087", true, DateUtil.convertToDate("15/03/2017"),
				"Science Fiction", true));
		allMoviesList.add(new Movie(1002L, "The Avengers", "$1,518,812,988", true,
				DateUtil.convertToDate("23/12/2017"), "Superhero", false));
		allMoviesList.add(new Movie(1003L, "Titanic", "$2,187,463,944", true, DateUtil.convertToDate("21/08/2017"),
				"Romance", false));
		allMoviesList.add(new Movie(1004L, "Jurassic World", "$1,671,713,208", false,
				DateUtil.convertToDate("02/07/2017"), "Science Fiction", false));
		allMoviesList.add(new Movie(1005L, "Avengers: End Game", "$2,750,760,348",true,
				DateUtil.convertToDate("02/11/2022"), "Superhero", false));
	}

	public List<Movie> getAllMovies() {
		return allMoviesList;
	}

	public void addMovie(Movie movie) {
		allMoviesList.add(movie);
	}

	public Movie getMovieById(long movieId) {
		return allMoviesList.stream().filter(movie -> movie.getId() == movieId).findAny().orElse(null);
	}

	public void updateMovie(Movie movie) {
		int index = allMoviesList.indexOf(getMovieById(movie.getId()));
		allMoviesList.set(index, movie);
	}

	public void deleteMovie(long id) {
		int index = allMoviesList.indexOf(getMovieById(id));
		allMoviesList.remove(index);
	}
	
	public Favourites getFavouritesForUser(String userId) {
		return allUserFavourites.get(userId);
	}
	
	public void addFavourite(String userId,long movieId) {
		if(!allUserFavourites.containsKey(userId)) {
			allUserFavourites.put(userId, new Favourites(new ArrayList<Movie>(),0L));
		}
		getFavouritesForUser(userId).getMovieList().add(getMovieById(movieId));
		getFavouritesForUser(userId).setNoOfFavorites(getFavouritesForUser(userId).getMovieList().size());
	}
	
	public void deleteFromFavourites(String userId,long id) {
		int index=getFavouritesForUser(userId).getMovieList().indexOf(getMovieById(id));
		getFavouritesForUser(userId).getMovieList().remove(index);
		getFavouritesForUser(userId).setNoOfFavorites(getFavouritesForUser(userId).getMovieList().size());
	}

	
}
