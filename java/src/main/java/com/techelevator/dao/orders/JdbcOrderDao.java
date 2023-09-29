package com.techelevator.dao.orders;

import com.techelevator.dao.menu.PizzaDao;
import com.techelevator.model.menu.MenuItem;
import com.techelevator.model.menu.Pizza;
import com.techelevator.model.orders.Order;
import com.techelevator.model.orders.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcOrderDao implements OrderDao{

    @Autowired
    private PizzaDao pizzaDao;
    private final JdbcTemplate jdbcTemplate;
    public JdbcOrderDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public int create(Order order) {

        String sql = "INSERT INTO orders (status, data_id, delivery, total) VALUES (?, ?, ?, ?) RETURNING order_id;";
        String sql2 = "INSERT INTO orders_to_menu_items (order_id, item_id, quantity) VALUES (?, ?, ?);";
        int newId = -1;
        try{
            order.setStatus("pending");
            newId = jdbcTemplate.queryForObject(sql, Integer.class, order.getStatus(), order.getDataId(), order.isDelivery(), order.getTotal());
            if(newId == -1){throw new Exception();}
            System.out.println(order.getCustomPizzas());
            System.out.println(order.getMenuItems());
            for(Pizza pizza : order.getCustomPizzas()){
                int pizzaId = -1;
                pizzaId = pizzaDao.create(pizza);
                if(pizzaId == -1){throw new Exception();}
                if(jdbcTemplate.update(sql2, newId, pizzaId, pizza.getQuantity()) != 1){
                    throw new Exception();
                }
            }
            for(MenuItem menuItem : order.getMenuItems()){
                if(jdbcTemplate.update(sql2, newId, menuItem.getItemId(), menuItem.getQuantity()) != 1){
                    throw new Exception();
                }
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return newId;

    }

    @Override
    public Order getOrderById(int orderId) {
        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        return null;
    }

    @Override
    public boolean updateStatus(OrderStatus orderStatus) {
        return false;
    }
}
