package com.techelevator.dao;

import com.techelevator.model.Pizza;

public interface PizzaDao {

    int create(Pizza pizza);
    Pizza getPizzaById(int id);

}
