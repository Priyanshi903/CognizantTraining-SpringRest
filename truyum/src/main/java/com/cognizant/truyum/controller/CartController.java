package com.cognizant.truyum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.service.CartService;

@RequestMapping("/carts")
@RestController
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@GetMapping("/{userid}")
	public Cart getCartForUser(@PathVariable String userid) throws CartEmptyException {
		return cartService.getCartForUser(userid);
	}
	
	@PostMapping("/{userid}/{menuItemId}")
	public Cart addcartItem(@PathVariable String userid, @PathVariable long menuItemId) throws MenuItemNotFoundException {
		return cartService.addcartItem(userid,menuItemId);
	}
	
	@DeleteMapping("/{userId}/{menuItemId}")
	public Cart removeCartItem(@PathVariable String userId,@PathVariable long menuItemId) throws MenuItemNotFoundException, CartEmptyException {
		cartService.removeCartItem(userId,menuItemId);
		return cartService.getCartForUser(userId);
	}

}
