package com.getmedbd.db.models;

import java.io.Serializable;

/**
 * Medicine model representing a medicine in the system
 */
public class Medicine implements Serializable {
    private String id;
    private String name;
    private double price;

    public Medicine() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
