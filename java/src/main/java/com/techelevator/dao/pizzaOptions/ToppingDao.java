package com.techelevator.dao.pizzaOptions;

import com.techelevator.model.pizzaOptions.Topping;

import java.util.List;

public interface ToppingDao {
    Topping getToppingById(int id);
    Topping addToppingToTable (Topping topping);
    List<Topping> getAllToppings();
}
