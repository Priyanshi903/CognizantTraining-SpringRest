package com.cognizant.truyum.dao;

import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.Cart;

public interface CartDao {
	Cart addcartItem(String userId, long menuItemId) throws MenuItemNotFoundException;

	void removeCartItem(String userId, long menuItemId) throws MenuItemNotFoundException;
	
	Cart getCartForUser(String userid);
	
	double total(String userid);
}