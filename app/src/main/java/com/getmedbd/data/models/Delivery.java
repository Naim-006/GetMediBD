package com.getmedbd.data.models;

import java.io.Serializable;

/**
 * Delivery model representing a delivery assignment in the system
 */
public class Delivery implements Serializable {
    private String id;
    private String orderId;
    private String riderId;
    private String pharmacyId;
    private String customerId;
    private String pickupAddress;
    private String deliveryAddress;
    private String status; // assigned, picked_up, out_for_delivery, delivered, cancelled
    private String pickupOtp;
    private String deliveryOtp;
    private double deliveryFee;
    private String paymentMethod;
    private boolean isCashCollected;
    private long assignedAt;
    private long deliveredAt;

    public Delivery() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    public String getRiderId() { return riderId; }
    public void setRiderId(String riderId) { this.riderId = riderId; }
    public String getPharmacyId() { return pharmacyId; }
    public void setPharmacyId(String pharmacyId) { this.pharmacyId = pharmacyId; }
    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }
    public String getPickupAddress() { return pickupAddress; }
    public void setPickupAddress(String pickupAddress) { this.pickupAddress = pickupAddress; }
    public String getDeliveryAddress() { return deliveryAddress; }
    public void setDeliveryAddress(String deliveryAddress) { this.deliveryAddress = deliveryAddress; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getPickupOtp() { return pickupOtp; }
    public void setPickupOtp(String pickupOtp) { this.pickupOtp = pickupOtp; }
    public String getDeliveryOtp() { return deliveryOtp; }
    public void setDeliveryOtp(String deliveryOtp) { this.deliveryOtp = deliveryOtp; }
    public double getDeliveryFee() { return deliveryFee; }
    public void setDeliveryFee(double deliveryFee) { this.deliveryFee = deliveryFee; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public boolean isCashCollected() { return isCashCollected; }
    public void setCashCollected(boolean cashCollected) { isCashCollected = cashCollected; }
    public long getAssignedAt() { return assignedAt; }
    public void setAssignedAt(long assignedAt) { this.assignedAt = assignedAt; }
    public long getDeliveredAt() { return deliveredAt; }
    public void setDeliveredAt(long deliveredAt) { this.deliveredAt = deliveredAt; }
}
