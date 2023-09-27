package com.techelevator.dao;


import com.techelevator.model.Topping;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;

import java.util.Objects;

@Component
public class JdbcToppingDao implements ToppingDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcToppingDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public Topping getToppingById(int id) {
        String sql = "SELECT * FROM toppings WHERE topping_id = ?;";
        Topping topping = new Topping();
        try{
            SqlRowSet row = jdbcTemplate.queryForRowSet(sql, id);
            if(row.next()){
                topping = mapRowToTopping(row);
            }
        } catch (ResourceAccessException | DataAccessException e){
            System.out.println(e.getMessage());
        }
        return topping;
    }

    private Topping mapRowToTopping(SqlRowSet rs) {
        Topping topping = new Topping();
        topping.setId(rs.getInt("topping_id"));
        topping.setName(rs.getString("name"));
        topping.setAvailable(rs.getBoolean("available"));
        topping.setPrice(rs.getBigDecimal("price"));
        return topping;
    }
}
