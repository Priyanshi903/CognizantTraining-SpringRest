package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.model.MenuItem;

@Repository
public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private static ApplicationContext context;
	private static List<MenuItem> menuItemList;

	static {
		context = new ClassPathXmlApplicationContext("truyum.xml");
		menuItemList = (List<MenuItem>) context.getBean("menuItemList");
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		return MenuItemDaoCollectionImpl.menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {

		List<MenuItem> filteredList = new ArrayList<>();
		Date now = new Date();

		for (MenuItem obj : MenuItemDaoCollectionImpl.menuItemList) {
			if (obj.isActive() && now.compareTo(obj.getDateOfLaunch()) >= 0) {
				filteredList.add(obj);
			}
		}

		return filteredList;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		MenuItem menuItem2=getMenuItemById(menuItem.getId());
		int index=menuItemList.indexOf(menuItem2);
		menuItemList.set(index, menuItem);
	}

	@Override
	public MenuItem getMenuItemById(long menuItemId) {
		return getMenuItemListAdmin().stream().filter(m -> m.getId() == menuItemId).findAny().orElse(null);
	}

	@Override
	public MenuItem save(MenuItem menuItem) {
		menuItemList.add(menuItem);
		return getMenuItemById(menuItem.getId());
	}

}
