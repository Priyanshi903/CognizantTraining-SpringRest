package com.cognizant.truyum.exception;

public class CartEmptyException extends Exception{
	
	public CartEmptyException() {
		
	}
	
	public CartEmptyException(String mssg) {
		super(mssg);
	}

}
