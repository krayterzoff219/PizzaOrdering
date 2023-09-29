package com.techelevator.dao.menu;

import com.techelevator.model.menu.MenuItem;

import java.util.List;

public interface MenuItemDao {

    List<MenuItem> getAllMenuItems();
    MenuItem getMenuItemById(int id);
    int addMenuItem(MenuItem menuItem);
    int addSpecialtyPizza(MenuItem menuItem);
    boolean updateMenuItem(MenuItem menuItem);

}
