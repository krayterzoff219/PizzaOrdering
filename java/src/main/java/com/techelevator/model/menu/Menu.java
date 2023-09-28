package com.techelevator.model.menu;

import com.techelevator.model.pizzaOptions.Crust;
import com.techelevator.model.pizzaOptions.Sauce;
import com.techelevator.model.pizzaOptions.Size;
import com.techelevator.model.pizzaOptions.Topping;

import java.util.List;

public class Menu {

    private List<Topping> toppings;
    private List<Size> sizes;
    private List<Crust> crusts;
    private List<Sauce> sauces;

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public List<Size> getSizes() {
        return sizes;
    }

    public void setSizes(List<Size> sizes) {
        this.sizes = sizes;
    }

    public List<Crust> getCrusts() {
        return crusts;
    }

    public void setCrusts(List<Crust> crusts) {
        this.crusts = crusts;
    }

    public List<Sauce> getSauces() {
        return sauces;
    }

    public void setSauces(List<Sauce> sauces) {
        this.sauces = sauces;
    }
}
