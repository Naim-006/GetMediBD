package com.getmedbd.data.models;

import java.io.Serializable;

/**
 * Order model
 */
public class Order implements Serializable {
    private String id;
    private String userId;
    private String pharmacyId;
    private String status;
    private double totalAmount;
    
    public Order() {}
    
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getPharmacyId() { return pharmacyId; }
    public void setPharmacyId(String pharmacyId) { this.pharmacyId = pharmacyId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
}
