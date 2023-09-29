package com.techelevator.model.menu;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techelevator.model.pizzaOptions.Crust;
import com.techelevator.model.pizzaOptions.Sauce;
import com.techelevator.model.pizzaOptions.Size;
import com.techelevator.model.pizzaOptions.Topping;

import java.util.List;

public class Pizza {

    private int id;
    private Size size;
    private Crust crust;
    private Sauce sauce;
    private List<Topping> toppings;
    private int quantity;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Crust getCrust() {
        return crust;
    }

    public void setCrust(Crust crust) {
        this.crust = crust;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", size=" + size.getId() +
                ", crust=" + crust.getId() +
                ", sauce=" + sauce.getId() +
                ", toppings=" + toppings +
                '}';
    }
}
