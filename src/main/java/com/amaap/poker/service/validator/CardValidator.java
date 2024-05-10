package com.amaap.poker.service.validator;

import java.util.Arrays;

public class CardValidator {

    static String[] suits = {"H", "D", "C", "S"};
    static String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};

    public static boolean validate(String suit, String value) {
        boolean isSuitPresent = Arrays.asList(suits).contains(suit);
        boolean isValuePresent = Arrays.asList(values).contains(value);

        return isSuitPresent && isValuePresent;
    }


}
