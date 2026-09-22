package com.getmedbd.data.models;

import java.io.Serializable;

/**
 * Rider profile model
 */
public class Rider implements Serializable {
    private String id;
    private String userId;
    private String vehicleType;
    private String vehiclePlateNumber;
    private String drivingLicenseNumber;
    private String nidNumber;
    private boolean isAvailable;
    private boolean isVerified;
    private double currentLatitude;
    private double currentLongitude;
    private double rating;
    private int totalDeliveries;

    public Rider() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getVehicleType() { return vehicleType; }
    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }
    public String getVehiclePlateNumber() { return vehiclePlateNumber; }
    public void setVehiclePlateNumber(String vehiclePlateNumber) { this.vehiclePlateNumber = vehiclePlateNumber; }
    public String getDrivingLicenseNumber() { return drivingLicenseNumber; }
    public void setDrivingLicenseNumber(String drivingLicenseNumber) { this.drivingLicenseNumber = drivingLicenseNumber; }
    public String getNidNumber() { return nidNumber; }
    public void setNidNumber(String nidNumber) { this.nidNumber = nidNumber; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
    public boolean isVerified() { return isVerified; }
    public void setVerified(boolean verified) { isVerified = verified; }
    public double getCurrentLatitude() { return currentLatitude; }
    public void setCurrentLatitude(double currentLatitude) { this.currentLatitude = currentLatitude; }
    public double getCurrentLongitude() { return currentLongitude; }
    public void setCurrentLongitude(double currentLongitude) { this.currentLongitude = currentLongitude; }
    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
    public int getTotalDeliveries() { return totalDeliveries; }
    public void setTotalDeliveries(int totalDeliveries) { this.totalDeliveries = totalDeliveries; }
}
