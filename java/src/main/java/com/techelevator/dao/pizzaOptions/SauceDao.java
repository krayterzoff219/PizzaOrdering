package com.techelevator.dao.pizzaOptions;

import com.techelevator.model.pizzaOptions.Sauce;

import java.util.List;

public interface SauceDao {
    Sauce getSauceById(int id);
    Sauce addSauceToTable (Sauce topping);
    List<Sauce> getAllSauces();
    boolean updateSauce (Sauce sauce);

}
