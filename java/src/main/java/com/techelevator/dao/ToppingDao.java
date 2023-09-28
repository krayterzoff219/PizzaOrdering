package com.techelevator.dao;

import com.techelevator.model.Topping;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;

public interface ToppingDao {
    Topping getToppingById(int id);
    Topping addToppingToTable (Topping topping);
    List<Topping> getAllToppings();
}
