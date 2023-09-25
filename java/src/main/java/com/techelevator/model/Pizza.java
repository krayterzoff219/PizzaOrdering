package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pizza {

    private String size;
    private String crust;
    private String sauce;
    @JsonProperty("cheese")
    private boolean hasCheese;
    @JsonProperty("pepperoni")
    private boolean hasPepperoni;
    @JsonProperty("mushrooms")
    private boolean hasMushroom;


    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public boolean isHasCheese() {
        return hasCheese;
    }

    public void setHasCheese(boolean hasCheese) {
        this.hasCheese = hasCheese;
    }

    public boolean isHasPepperoni() {
        return hasPepperoni;
    }

    public void setHasPepperoni(boolean hasPepperoni) {
        this.hasPepperoni = hasPepperoni;
    }

    public boolean isHasMushroom() {
        return hasMushroom;
    }

    public void setHasMushroom(boolean hasMushroom) {
        this.hasMushroom = hasMushroom;
    }
}
