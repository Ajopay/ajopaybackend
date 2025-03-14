package com.example.ajopay.utils;

import java.security.SecureRandom;

public class AccountNumberGen {


    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public static String generateAccountNumber() {
        int random= 100000000 + SECURE_RANDOM.nextInt(90000000);
        return "00" + random;
    }
}
