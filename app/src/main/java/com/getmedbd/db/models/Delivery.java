package com.getmedbd.db.models;

import java.io.Serializable;

/**
 * Delivery model representing an active or completed delivery assignment
 * Responsible: Jhuma (252-15-713)
 */
public class Delivery implements Serializable {
    // Status Constants
    public static final String STATUS_ASSIGNED = "ASSIGNED";
    public static final String STATUS_PICKED_UP = "PICKED_UP";
    public static final String STATUS_IN_TRANSIT = "IN_TRANSIT";
    public static final String STATUS_DELIVERED = "DELIVERED";
    public static final String STATUS_CANCELLED = "CANCELLED";

    private String id;
    private String orderId;
    private String riderId;
    private String status;

    // Pharmacy Details
    private String pharmacyName;
    private String pharmacyAddress;
    private String pharmacyPhone;
    private double pharmacyLatitude;
    private double pharmacyLongitude;

    // Customer Details
    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private double customerLatitude;
    private double customerLongitude;

    // Order Content & Pricing
    private String medicinesSummary;
    private double deliveryFee;
    private double codAmount;
    private boolean isCod;
    private double distanceKm;

    // Security & Verification
    private String pickupOtp;
    private String deliveryOtp;
    private String proofPhotoUri;

    // Timestamps
    private String assignedTime;
    private String pickedUpTime;
    private String deliveredTime;

    public Delivery() {
        this.status = STATUS_ASSIGNED;
    }

    public Delivery(String id, String orderId, String pharmacyName, String customerName, 
                    String customerAddress, double deliveryFee, double codAmount, boolean isCod) {
        this();
        this.id = id;
        this.orderId = orderId;
        this.pharmacyName = pharmacyName;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.deliveryFee = deliveryFee;
        this.codAmount = codAmount;
        this.isCod = isCod;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public String getRiderId() { return riderId; }
    public void setRiderId(String riderId) { this.riderId = riderId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPharmacyName() { return pharmacyName; }
    public void setPharmacyName(String pharmacyName) { this.pharmacyName = pharmacyName; }

    public String getPharmacyAddress() { return pharmacyAddress; }
    public void setPharmacyAddress(String pharmacyAddress) { this.pharmacyAddress = pharmacyAddress; }

    public String getPharmacyPhone() { return pharmacyPhone; }
    public void setPharmacyPhone(String pharmacyPhone) { this.pharmacyPhone = pharmacyPhone; }

    public double getPharmacyLatitude() { return pharmacyLatitude; }
    public void setPharmacyLatitude(double pharmacyLatitude) { this.pharmacyLatitude = pharmacyLatitude; }

    public double getPharmacyLongitude() { return pharmacyLongitude; }
    public void setPharmacyLongitude(double pharmacyLongitude) { this.pharmacyLongitude = pharmacyLongitude; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getCustomerAddress() { return customerAddress; }
    public void setCustomerAddress(String customerAddress) { this.customerAddress = customerAddress; }

    public String getCustomerPhone() { return customerPhone; }
    public void setCustomerPhone(String customerPhone) { this.customerPhone = customerPhone; }

    public double getCustomerLatitude() { return customerLatitude; }
    public void setCustomerLatitude(double customerLatitude) { this.customerLatitude = customerLatitude; }

    public double getCustomerLongitude() { return customerLongitude; }
    public void setCustomerLongitude(double customerLongitude) { this.customerLongitude = customerLongitude; }

    public String getMedicinesSummary() { return medicinesSummary; }
    public void setMedicinesSummary(String medicinesSummary) { this.medicinesSummary = medicinesSummary; }

    public double getDeliveryFee() { return deliveryFee; }
    public void setDeliveryFee(double deliveryFee) { this.deliveryFee = deliveryFee; }

    public double getCodAmount() { return codAmount; }
    public void setCodAmount(double codAmount) { this.codAmount = codAmount; }

    public boolean isCod() { return isCod; }
    public void setCod(boolean cod) { isCod = cod; }

    public double getDistanceKm() { return distanceKm; }
    public void setDistanceKm(double distanceKm) { this.distanceKm = distanceKm; }

    public String getPickupOtp() { return pickupOtp; }
    public void setPickupOtp(String pickupOtp) { this.pickupOtp = pickupOtp; }

    public String getDeliveryOtp() { return deliveryOtp; }
    public void setDeliveryOtp(String deliveryOtp) { this.deliveryOtp = deliveryOtp; }

    public String getProofPhotoUri() { return proofPhotoUri; }
    public void setProofPhotoUri(String proofPhotoUri) { this.proofPhotoUri = proofPhotoUri; }

    public String getAssignedTime() { return assignedTime; }
    public void setAssignedTime(String assignedTime) { this.assignedTime = assignedTime; }

    public String getPickedUpTime() { return pickedUpTime; }
    public void setPickedUpTime(String pickedUpTime) { this.pickedUpTime = pickedUpTime; }

    public String getDeliveredTime() { return deliveredTime; }
    public void setDeliveredTime(String deliveredTime) { this.deliveredTime = deliveredTime; }
}
