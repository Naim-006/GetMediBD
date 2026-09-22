package com.getmedbd.core.utils;

/**
 * Utility class for String operations
 */
public class StringUtils {
    
    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
    
    private StringUtils() {
        // Private constructor
    }
}
