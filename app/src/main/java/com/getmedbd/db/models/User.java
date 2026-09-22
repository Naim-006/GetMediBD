package com.getmedbd.db.models;

import java.io.Serializable;

/**
 * User model representing a user in the system
 */
public class User implements Serializable {
    private String id;
    private String email;
    private String name;
    private String role;

    public User() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
