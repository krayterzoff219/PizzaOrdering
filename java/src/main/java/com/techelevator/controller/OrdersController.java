package com.techelevator.controller;

import com.techelevator.dao.login.UserDao;
import com.techelevator.dao.login.UserDataDao;
import com.techelevator.dao.orders.OrderDao;
import com.techelevator.model.orders.Order;
import com.techelevator.model.pizzaOptions.Topping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;

@RestController
//@PreAuthorize("isAuthenticated()")
@PreAuthorize("permitAll()")
@CrossOrigin
public class OrdersController {

    @Autowired
    private UserDataDao userDataDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserDao userDao;


    @RequestMapping(path = "/orders", method = RequestMethod.POST)
    public int addOrder(@RequestBody Order order, Principal principal){
        if(principal == null){
            order.setDataId(userDataDao.createGuestData(order));
        }else{
            order.setDataId(userDataDao.getUserData(userDao.findIdByUsername(principal.getName())).getDataId());
        }
        return orderDao.create(order);
    }
}
