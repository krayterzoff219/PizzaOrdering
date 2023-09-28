package com.techelevator.dao.pizzaOptions;

import com.techelevator.model.pizzaOptions.Size;

import java.util.List;

public interface SizeDao {
    Size getSizeById(int id);
    Size addSizeToTable (Size Size);
    List<Size> getAllSizes();
}
