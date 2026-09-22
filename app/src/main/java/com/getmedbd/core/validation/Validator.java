package com.getmedbd.core.validation;

/**
 * Validator utility class for input validation
 */
public class Validator {
    
    public static boolean isValidPassword(String password) {
        return password != null && password.length() >= 6;
    }
}
