package com.cognizant.moviecruiser.exception;

public class FavouritesEmptyException extends Exception{
	
	public FavouritesEmptyException() {
		
	}
	
	public FavouritesEmptyException(String mssg) {
		super(mssg);
	}

}
