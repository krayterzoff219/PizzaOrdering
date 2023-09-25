package com.techelevator.dao;

import com.techelevator.model.Pizza;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;

@Component
public class JdbcPizzaDao implements PizzaDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcPizzaDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int create(Pizza pizza) {
        String sql = "INSERT INTO pizzas (size, crust, sauce, cheese, pepperoni, mushrooms)" +
                "VALUES (?,?,?,?,?,?) RETURNING pizza_id;";
        int newId = -1;
        try{
            newId = jdbcTemplate.queryForObject(sql, Integer.class, pizza.getSize(), pizza.getCrust(), pizza.getSauce(), pizza.isHasCheese(),
                    pizza.isHasPepperoni(), pizza.isHasMushroom());
            // throw exception if newId still -1
        } catch (ResourceAccessException | DataAccessException e){
            System.out.println(e.getMessage());
        }
        return newId;
    }

    @Override
    public Pizza getPizzaById(int id) {
        String sql = "SELECT * FROM pizzas WHERE pizza_id = ?;";
        Pizza myPizza = new Pizza();
        try{
            SqlRowSet row = jdbcTemplate.queryForRowSet(sql, id);
            if(row.next()){
                myPizza = mapRowToPizza(row);
            }
        } catch (ResourceAccessException | DataAccessException e){
            System.out.println(e.getMessage());
        }
        return myPizza;
    }






    private Pizza mapRowToPizza(SqlRowSet row){
        Pizza pizza = new Pizza();
        pizza.setSize(row.getString("size"));
        pizza.setCrust(row.getString("crust"));
        pizza.setSauce(row.getString("sauce"));
        pizza.setHasCheese(row.getBoolean("cheese"));
        pizza.setHasPepperoni(row.getBoolean("pepperoni"));
        pizza.setHasMushroom(row.getBoolean("mushrooms"));

        return pizza;
    }
}
