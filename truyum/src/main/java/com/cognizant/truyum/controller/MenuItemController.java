package com.cognizant.truyum.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@RestController
@RequestMapping("/menu-Items")
public class MenuItemController {
	
	@Autowired
	private MenuItemService menuItemService;
	
	@GetMapping
	public List<MenuItem> getAllMenuItems(){
		return menuItemService.getMenuItemListCustomer();
	}
	
	@GetMapping("/{id}")
	public MenuItem getMenuItemById(@PathVariable long id) throws MenuItemNotFoundException {
		return menuItemService.getMenuItemById(id);
	}
	
	@PutMapping
	public MenuItem modifyMenuItem(@RequestBody @Valid MenuItem menuItem) throws MenuItemNotFoundException {
		menuItemService.modifyMenuItem(menuItem);
		return menuItemService.getMenuItemById(menuItem.getId());
	}
	
	@GetMapping("/admin")
	public List<MenuItem> getAllMenuItemsAdmin(){
		return menuItemService.getMenuItemListAdmin();
	}
	
	@PostMapping
	public MenuItem save(@RequestBody @Valid MenuItem menuItem) throws MenuItemNotFoundException {
		menuItemService.save(menuItem);
		return menuItemService.getMenuItemById(menuItem.getId());
	}
	

}
