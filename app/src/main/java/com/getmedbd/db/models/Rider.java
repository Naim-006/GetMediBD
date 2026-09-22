package com.getmedbd.db.models;

import java.io.Serializable;

/**
 * Rider profile model
 */
public class Rider implements Serializable {
    private String id;
    private String userId;
    private boolean isAvailable;

    public Rider() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
}
