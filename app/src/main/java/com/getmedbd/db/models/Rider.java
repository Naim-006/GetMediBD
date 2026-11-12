package com.getmedbd.db.models;

import java.io.Serializable;

/**
 * Rider model representing a delivery partner profile in GetMediBD
 * Responsible: Jhuma (252-15-713)
 */
public class Rider implements Serializable {
    private String id;
    private String userId;
    private String name;
    private String phone;
    private String email;
    private String vehicleType;       // Bicycle, Motorbike, Scooter
    private String vehiclePlateNumber; // e.g., Dhaka Metro-Ha-45-7890
    private boolean isAvailable;       // Online / Offline toggle
    private String verificationStatus; // VERIFIED, PENDING, REJECTED
    private String nidNumber;
    private String drivingLicenseNumber;
    private double rating;             // e.g., 4.9
    private int totalDeliveries;
    private double todayEarnings;
    private double totalEarnings;
    private double codCashInHand;      // Cash collected to be remitted
    private double currentLatitude;
    private double currentLongitude;

    public Rider() {
        this.verificationStatus = "VERIFIED";
        this.isAvailable = true;
        this.rating = 4.9;
    }

    public Rider(String id, String name, String phone, String vehicleType, String vehiclePlateNumber) {
        this();
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.vehicleType = vehicleType;
        this.vehiclePlateNumber = vehiclePlateNumber;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getVehicleType() { return vehicleType; }
    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }

    public String getVehiclePlateNumber() { return vehiclePlateNumber; }
    public void setVehiclePlateNumber(String vehiclePlateNumber) { this.vehiclePlateNumber = vehiclePlateNumber; }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    public String getVerificationStatus() { return verificationStatus; }
    public void setVerificationStatus(String verificationStatus) { this.verificationStatus = verificationStatus; }

    public String getNidNumber() { return nidNumber; }
    public void setNidNumber(String nidNumber) { this.nidNumber = nidNumber; }

    public String getDrivingLicenseNumber() { return drivingLicenseNumber; }
    public void setDrivingLicenseNumber(String drivingLicenseNumber) { this.drivingLicenseNumber = drivingLicenseNumber; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public int getTotalDeliveries() { return totalDeliveries; }
    public void setTotalDeliveries(int totalDeliveries) { this.totalDeliveries = totalDeliveries; }

    public double getTodayEarnings() { return todayEarnings; }
    public void setTodayEarnings(double todayEarnings) { this.todayEarnings = todayEarnings; }

    public double getTotalEarnings() { return totalEarnings; }
    public void setTotalEarnings(double totalEarnings) { this.totalEarnings = totalEarnings; }

    public double getCodCashInHand() { return codCashInHand; }
    public void setCodCashInHand(double codCashInHand) { this.codCashInHand = codCashInHand; }

    public double getCurrentLatitude() { return currentLatitude; }
    public void setCurrentLatitude(double currentLatitude) { this.currentLatitude = currentLatitude; }

    public double getCurrentLongitude() { return currentLongitude; }
    public void setCurrentLongitude(double currentLongitude) { this.currentLongitude = currentLongitude; }
}
