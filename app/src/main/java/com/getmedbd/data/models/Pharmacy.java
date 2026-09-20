package com.getmedbd.data.models;

import java.io.Serializable;

/**
 * Pharmacy model
 */
public class Pharmacy implements Serializable {
    private String id;
    private String name;
    private String address;
    private double latitude;
    private double longitude;
    private String phone;
    
    public Pharmacy() {}
    
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }
    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
