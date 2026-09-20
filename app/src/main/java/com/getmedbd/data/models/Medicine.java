package com.getmedbd.data.models;

import java.io.Serializable;

/**
 * Medicine model representing a medicine in the system
 */
public class Medicine implements Serializable {
    
    private String id;
    private String name;
    private String genericName;
    private String description;
    private String manufacturer;
    private double price;
    private int stockQuantity;
    private String category;
    private boolean requiresPrescription;
    private String imageUrl;
    private String pharmacyId;
    
    public Medicine() {
    }
    
    // Getters and Setters
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getGenericName() {
        return genericName;
    }
    
    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getManufacturer() {
        return manufacturer;
    }
    
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public int getStockQuantity() {
        return stockQuantity;
    }
    
    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public boolean isRequiresPrescription() {
        return requiresPrescription;
    }
    
    public void setRequiresPrescription(boolean requiresPrescription) {
        this.requiresPrescription = requiresPrescription;
    }
    
    public String getImageUrl() {
        return imageUrl;
    }
    
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public String getPharmacyId() {
        return pharmacyId;
    }
    
    public void setPharmacyId(String pharmacyId) {
        this.pharmacyId = pharmacyId;
    }
}
