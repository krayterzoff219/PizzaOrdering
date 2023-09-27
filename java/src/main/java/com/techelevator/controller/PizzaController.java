package com.techelevator.controller;

import com.techelevator.dao.PizzaDao;
import com.techelevator.dao.ToppingDao;
import com.techelevator.model.Pizza;
import com.techelevator.model.Topping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
//@PreAuthorize("isAuthenticated()")
@PreAuthorize("permitAll()")
@CrossOrigin
public class PizzaController {

    @Autowired
    private PizzaDao pizzaDao;

    @Autowired
    private ToppingDao toppingDao;

    @RequestMapping(path = "/pizza", method = RequestMethod.POST)
    public int addPizza(@RequestBody Pizza pizza){
        return pizzaDao.create(pizza);
    }

    @RequestMapping(path = "/pizza/{id}", method = RequestMethod.GET)
    public Pizza getPizzaById(@PathVariable int id){
        return pizzaDao.getPizzaById(id);
    }

    @RequestMapping(path = "/topping/{id}", method = RequestMethod.GET)
    public Topping getToppingById(@PathVariable int id){
        return toppingDao.getToppingById(id);
    }
}
