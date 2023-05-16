package com.ata.utils;

public class StringUtils {
    public static int parseToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch(NumberFormatException e) {
            // Handle the exception gracefully
            return 0; // or any other default value
        }
    }

    public static Double parseToDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch(NumberFormatException e) {
            // Handle the exception gracefully
            return 0.0; // or any other default value
        }
    }
}
