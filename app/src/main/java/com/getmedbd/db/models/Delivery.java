package com.getmedbd.db.models;

import java.io.Serializable;

/**
 * Delivery model representing a delivery assignment in the system
 */
public class Delivery implements Serializable {
    private String id;
    private String orderId;
    private String status;

    public Delivery() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
