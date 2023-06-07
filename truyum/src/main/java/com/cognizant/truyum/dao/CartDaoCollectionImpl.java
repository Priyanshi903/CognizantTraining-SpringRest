package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@Repository
public class CartDaoCollectionImpl implements CartDao {
	
	private Map<String,Cart> userCart;
	
	@Autowired
	private MenuItemService menuItemService;
	
	public CartDaoCollectionImpl() {
		userCart=new HashMap<>();
	}

	@Override
	public Cart addcartItem(String userId, long menuItemId) throws MenuItemNotFoundException {
		if(!userCart.containsKey(userId)) {
			userCart.put(userId, new Cart(new ArrayList<MenuItem>(),0.0));
		}
		MenuItem menuItem=menuItemService.getMenuItemById(menuItemId);
		userCart.get(userId).getMenuItemList().add(menuItem);
		userCart.get(userId).setTotal(total(userId));
		return getCartForUser(userId);
	}


	@Override
	public void removeCartItem(String userId, long menuItemId) throws MenuItemNotFoundException {
		Cart cart=getCartForUser(userId);
		List<MenuItem> menuItemsInCart=getCartForUser(userId).getMenuItemList();
		int index=menuItemsInCart.indexOf(menuItemService.getMenuItemById(menuItemId));
		cart.getMenuItemList().remove(index);
	}
	
	@Override
	public Cart getCartForUser(String userid) {
		
		return userCart.get(userid);
	}

	@Override
	public double total(String userid) {
		Double totalPrice= getCartForUser(userid).getMenuItemList().stream().collect(Collectors.summingDouble(m->m.getPrice()));
		
		return totalPrice;
	}
	
	

}
