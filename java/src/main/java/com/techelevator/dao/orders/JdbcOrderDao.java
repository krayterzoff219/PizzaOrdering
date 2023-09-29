package com.techelevator.dao.orders;

import com.techelevator.model.orders.Order;
import com.techelevator.model.orders.OrderStatus;
import com.techelevator.model.pizzaOptions.Crust;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@Component
public class JdbcOrderDao implements OrderDao{

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
            newId = jdbcTemplate.queryForObject(sql, Integer.class, order.getStatus(), order.getDataId(), order.isDelivery(), order.getTotal());
            if(newId == -1){
                throw new Exception();
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
