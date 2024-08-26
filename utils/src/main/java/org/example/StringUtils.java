package org.example;

public class StringUtils {
    public static boolean isPositiveNumber(String str) {
        try {
            return Integer.parseInt(str) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
