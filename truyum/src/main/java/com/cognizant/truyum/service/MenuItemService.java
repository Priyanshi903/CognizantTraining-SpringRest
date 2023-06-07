package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;


@Service
public class MenuItemService {
	@Autowired
	private MenuItemDao menuItemDao;
	
	public List<MenuItem> getMenuItemListCustomer() {
		return menuItemDao.getMenuItemListCustomer();
	}

	public MenuItem getMenuItemById(long id) throws MenuItemNotFoundException {
		MenuItem menuItem=menuItemDao.getMenuItemById(id);
		if(menuItem==null)
			throw new MenuItemNotFoundException("MenuItem Not Found");
		return menuItem;
	}
	
	public void modifyMenuItem(MenuItem menuItem) throws MenuItemNotFoundException {
		getMenuItemById(menuItem.getId());
		menuItemDao.modifyMenuItem(menuItem);
	}

	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemDao.getMenuItemListAdmin();
	}

	public MenuItem save(MenuItem menuItem) {
		menuItemDao.save(menuItem);
		return menuItemDao.getMenuItemById(menuItem.getId());
	}
	
}
