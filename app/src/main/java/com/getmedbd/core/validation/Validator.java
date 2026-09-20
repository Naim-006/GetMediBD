package com.getmedbd.core.validation;

/**
 * Validator utility class for input validation
 */
public class Validator {
    
    public static boolean isValidPhoneNumber(String phone) {
        return phone != null && phone.matches("\\+?[0-9]{10,15}");
    }
    
    public static boolean isValidPassword(String password) {
        return password != null && password.length() >= 6;
    }
}
