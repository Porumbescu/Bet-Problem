package com.hcl.betproblem.util;

import java.security.SecureRandom;
import java.util.Random;

public class RandomStringGenerator {

    private static final String CHAR_SET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final Random RANDOM = new SecureRandom();

    public static String generateRandomString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int index = RANDOM.nextInt(CHAR_SET.length());
            stringBuilder.append(CHAR_SET.charAt(index));
        }
        return stringBuilder.toString();
    }
}
