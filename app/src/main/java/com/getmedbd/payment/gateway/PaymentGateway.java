package com.getmedbd.payment.gateway;

/**
 * Payment Gateway interface
 */
public class PaymentGateway {
    
    public boolean processPayment(String paymentMethod, double amount) {
        // Process payment through gateway
        return false;
    }
    
    public boolean refundPayment(String transactionId) {
        // Refund payment
        return false;
    }
}
