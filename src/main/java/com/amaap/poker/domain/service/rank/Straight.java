package com.amaap.poker.domain.service.rank;

import java.util.*;

public class Straight {
    public static boolean isStraight(List<String> cards) {
        Set<Integer> distinctValues = new HashSet<>();
        for (String card : cards) {
            int value = card.charAt(1);
            if (!distinctValues.contains(value)) distinctValues.add(value);
        }
        return isSortedValues(distinctValues);
    }

    private static boolean isSortedValues(Set<Integer> distinctValues) {
        if (distinctValues.size() == 5) {
            List<Integer> sortedValues = new ArrayList<>(distinctValues);
            Collections.sort(sortedValues);
            for (int i = 0; i < 4; i++) {
                if (sortedValues.get(i + 1) - sortedValues.get(i) != 1) return false;
            }
            return true;
        }
        return false;
    }
}
