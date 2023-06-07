package com.cognizant.truyum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.truyum.dao.CartDaoCollectionImpl;
import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.Cart;

@Service
public class CartService {
	
	@Autowired
	private CartDaoCollectionImpl cartDaoCollectionImpl;

	public Cart getCartForUser(String userid) throws CartEmptyException {
	
		if((cartDaoCollectionImpl.getCartForUser(userid)!=null) && !cartDaoCollectionImpl.getCartForUser(userid).getMenuItemList().isEmpty())
			return cartDaoCollectionImpl.getCartForUser(userid);
		throw new CartEmptyException("Your Cart is Empty, please eat something, we are very poor");
	}

	public Cart addcartItem(String userid, long menuItemId) throws MenuItemNotFoundException {
		return cartDaoCollectionImpl.addcartItem(userid, menuItemId);
	}

	public void removeCartItem(String userId, long menuItemId) throws MenuItemNotFoundException {
		
		cartDaoCollectionImpl.removeCartItem(userId, menuItemId);
		
	}
	
	

}
