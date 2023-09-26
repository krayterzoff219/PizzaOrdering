package com.techelevator.dao;

import com.techelevator.model.Topping;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public interface ToppingDao {
    Topping getToppingById(int id);
}
