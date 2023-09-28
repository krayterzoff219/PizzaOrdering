package com.techelevator.dao.menu;

import com.techelevator.dao.pizzaOptions.CrustDao;
import com.techelevator.dao.pizzaOptions.SauceDao;
import com.techelevator.dao.pizzaOptions.SizeDao;
import com.techelevator.dao.pizzaOptions.ToppingDao;
import com.techelevator.model.menu.Pizza;
import com.techelevator.model.pizzaOptions.Topping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPizzaDao implements PizzaDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private ToppingDao toppingDao;
    @Autowired
    private SizeDao sizeDao;
    @Autowired
    private CrustDao crustDao;
    @Autowired
    private SauceDao sauceDao;

    public JdbcPizzaDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int create(Pizza pizza) {
        String sql = "INSERT INTO pizzas (size_id, crust_id, sauce_id)" +
                "VALUES (?,?,?) RETURNING pizza_id;";
        int newId = -1;
        try{
            newId = jdbcTemplate.queryForObject(sql, Integer.class, pizza.getSize().getId(), pizza.getCrust().getId(), pizza.getSauce().getId());
            pizza.setId(newId);
            addToppingsToPizza(pizza);
            // throw exception if newId still -1
        } catch (ResourceAccessException | DataAccessException e){
            System.out.println(e.getMessage());
        }
        return newId;
    }

    @Override
    public Pizza getPizzaById(int id) {
        String sql = "SELECT * FROM pizzas WHERE pizza_id = ?;";
        String toppingSql = "SELECT * FROM pizzas_toppings WHERE pizza_id = ?;";
        Pizza myPizza = new Pizza();
        try{
            SqlRowSet row = jdbcTemplate.queryForRowSet(sql, id);
            if(row.next()){
                myPizza = mapRowToPizza(row);
            }
            row = jdbcTemplate.queryForRowSet(toppingSql, id);
            List<Topping> toppings = new ArrayList<>();
            while(row.next()){
                toppings.add(toppingDao.getToppingById(row.getInt("topping_id")));
            }
            myPizza.setToppings(toppings);
        } catch (ResourceAccessException | DataAccessException e){
            System.out.println(e.getMessage());
        }
        return myPizza;
    }




    private boolean addToppingsToPizza(Pizza pizza){

        String sql = "INSERT INTO pizzas_toppings (pizza_id, topping_id) VALUES (?, ?) RETURNING pizza_id;";
        List<Topping> toppings = pizza.getToppings();
        try{
            for(Topping topping : toppings){
                jdbcTemplate.queryForObject(sql, Integer.class, pizza.getId(), topping.getId());
            }
        } catch (ResourceAccessException | DataAccessException e){
            System.out.println(e.getMessage());
        }

        return true;
    }




    private Pizza mapRowToPizza(SqlRowSet row){
        Pizza pizza = new Pizza();
        pizza.setId(row.getInt("pizza_id"));
        pizza.setSize(sizeDao.getSizeById(row.getInt("size_id")));
        pizza.setCrust(crustDao.getCrustById(row.getInt("crust_id")));
        pizza.setSauce(sauceDao.getSauceById(row.getInt("sauce_id")));

        return pizza;
    }
}
