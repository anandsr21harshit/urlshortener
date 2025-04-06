package com.harshit.urlshortener.utils;

public class Base62Util {

    private static final String BASE62_CHARS =  "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int BASE = BASE62_CHARS.length();

    public static String encode(int value){
        if (value < 0) {
            throw new IllegalArgumentException("Value must be non-negative");
        }
        if (value == 0) {
            return String.valueOf(BASE62_CHARS.charAt(0)); // "0"
        }

        StringBuilder sb = new StringBuilder();
        while (value > 0){
            int remainder = value % BASE;
            sb.append(BASE62_CHARS.charAt(remainder));
            value = value / BASE;
        }
        return sb.reverse().toString();
    }
}
