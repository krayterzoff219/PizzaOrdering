package com.techelevator.dao.pizzaOptions;

import com.techelevator.model.pizzaOptions.Crust;

import java.util.List;

public interface CrustDao {
    Crust getCrustById(int id);
    Crust addCrustToTable (Crust topping);
    List<Crust> getAllCrusts();
    boolean updateCrust (Crust crust);
}
