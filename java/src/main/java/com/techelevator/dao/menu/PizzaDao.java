package com.techelevator.dao.menu;

import com.techelevator.model.menu.Pizza;

public interface PizzaDao {

    int create(Pizza pizza);
    Pizza getPizzaById(int id);

}
