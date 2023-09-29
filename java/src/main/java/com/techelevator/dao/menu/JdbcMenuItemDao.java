package com.techelevator.dao.menu;


import com.techelevator.model.menu.MenuItem;
import com.techelevator.model.menu.Pizza;
import com.techelevator.model.pizzaOptions.Crust;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMenuItemDao implements MenuItemDao {

    @Autowired
    private PizzaDao pizzaDao;
    private final JdbcTemplate jdbcTemplate;

    public JdbcMenuItemDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<MenuItem> getAllMenuItems() {
        String sql = "SELECT * FROM menu_items;";
        List<MenuItem> menuItemList = new ArrayList<>();
        try {
            MenuItem menuItem = new MenuItem();
            SqlRowSet row = jdbcTemplate.queryForRowSet(sql);
            while(row.next()){
                menuItem = mapRowToMenuItem(row);
                menuItemList.add(menuItem);
            }
        } catch (ResourceAccessException | DataAccessException e){
            System.out.println(e.getMessage());
        }

        return menuItemList;
    }

    @Override
    public MenuItem getMenuItemById(int id) {
        return null;
    }

    @Override
    public int addMenuItem(MenuItem menuItem) {
        String sql = "INSERT INTO menu_items (name, available, price, description, image_url) VALUES (?,?,?,?,?) RETURNING item_id;";
        int itemId = -1;
        try {
            itemId = jdbcTemplate.queryForObject(sql, Integer.class, menuItem.getName(), menuItem.isAvailable(), menuItem.getPrice(),
                    menuItem.getDescription(), menuItem.getImageURL());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return itemId;
    }

    @Override
    public int addSpecialtyPizza(MenuItem menuItem) {
        Pizza newPizza = menuItem.getPizza();
        int pizzaId = pizzaDao.create(newPizza);
        String sql = "INSERT INTO menu_items (name, available, price, description, image_url, pizza_id) VALUES (?,?,?,?,?,?) RETURNING item_id;";
        int itemId = -1;
        try {
            itemId = jdbcTemplate.queryForObject(sql, Integer.class, menuItem.getName(), menuItem.isAvailable(), menuItem.getPrice(),
                    menuItem.getDescription(), menuItem.getImageURL(), pizzaId);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return itemId;
    }

    @Override
    public boolean updateMenuItem(MenuItem menuItem) {
        String sql = "UPDATE menu_items SET name = ?, available = ?, price = ?, description = ?, image_url = ? WHERE item_id = ?;";
        int numOfRows = 0;
        try {
            numOfRows = jdbcTemplate.update(sql, menuItem.getName(), menuItem.isAvailable(), menuItem.getPrice(), menuItem.getDescription(),
                    menuItem.getImageURL(), menuItem.getItemId());
            if(numOfRows == 0){
                return false;
            }
        } catch (ResourceAccessException | DataAccessException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }




    private MenuItem mapRowToMenuItem(SqlRowSet row){
        MenuItem menuItem = new MenuItem();

        menuItem.setItemId(row.getInt("item_id"));
        menuItem.setName(row.getString("name"));
        menuItem.setAvailable(row.getBoolean("available"));
        menuItem.setPrice(row.getBigDecimal("price"));
        menuItem.setDescription(row.getString("description"));
        menuItem.setImageURL(row.getString("image_url"));

        int pizzaId = row.getInt("pizza_id");
        if (pizzaId != -1){
            menuItem.setPizza(pizzaDao.getPizzaById(pizzaId));
        }

        return menuItem;
    }
}
