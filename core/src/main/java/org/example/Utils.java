package org.example;

public class Utils {
    public static boolean isAllPositiveNumbers(String... str) {
        if (str.length == 0) {
            return false;
        }
        for (String s : str) {
            if (!StringUtils.isPositiveNumber(s)) {
                return false;
            }
        }
        return true;
    }
}
