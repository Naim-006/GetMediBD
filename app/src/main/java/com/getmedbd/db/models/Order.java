package com.getmedbd.db.models;

import java.io.Serializable;

/**
 * Order model
 */
public class Order implements Serializable {
    private String id;
    private String userId;
    private String status;

    public Order() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
