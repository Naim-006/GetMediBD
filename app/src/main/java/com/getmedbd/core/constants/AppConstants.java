package com.getmedbd.core.constants;

/**
 * Application-wide constants
 */
public class AppConstants {
    
    // API Constants
    public static final String BASE_URL = "https://api.getmedbd.com";
    public static final String API_VERSION = "v1";
    
    // Supabase Constants
    public static final String SUPABASE_URL = "https://your-project.supabase.co";
    public static final String SUPABASE_KEY = "your-supabase-key";
    
    // User Roles
    public static final String ROLE_CUSTOMER = "customer";
    public static final String ROLE_PHARMACY = "pharmacy";
    public static final String ROLE_RIDER = "rider";
    public static final String ROLE_ADMIN = "admin";
    public static final String ROLE_SUPERADMIN = "superadmin";
    
    // Order Status
    public static final String ORDER_PENDING = "pending";
    public static final String ORDER_CONFIRMED = "confirmed";
    public static final String ORDER_PROCESSING = "processing";
    public static final String ORDER_SHIPPED = "shipped";
    public static final String ORDER_DELIVERED = "delivered";
    public static final String ORDER_CANCELLED = "cancelled";

    // Delivery Status
    public static final String DELIVERY_ASSIGNED = "assigned";
    public static final String DELIVERY_PICKED_UP = "picked_up";
    public static final String DELIVERY_OUT_FOR_DELIVERY = "out_for_delivery";
    public static final String DELIVERY_DELIVERED = "delivered";
    public static final String DELIVERY_CANCELLED = "cancelled";
    
    // Prescription Status
    public static final String PRESCRIPTION_UPLOADED = "uploaded";
    public static final String PRESCRIPTION_PROCESSING = "processing";
    public static final String PRESCRIPTION_VERIFIED = "verified";
    public static final String PRESCRIPTION_REJECTED = "rejected";
    
    // SharedPreferences Keys
    public static final String PREF_USER_ID = "user_id";
    public static final String PREF_USER_EMAIL = "user_email";
    public static final String PREF_USER_ROLE = "user_role";
    public static final String PREF_AUTH_TOKEN = "auth_token";
    public static final String PREF_IS_LOGGED_IN = "is_logged_in";
    
    private AppConstants() {
        // Private constructor to prevent instantiation
    }
}
