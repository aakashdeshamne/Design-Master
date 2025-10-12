package Challange4.Entity;

import Challange4.Entity.Interfaces.Item;

public class Chocklet implements Item {
    private String name;
    private double price;
    private int quantity;

    public Chocklet(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
