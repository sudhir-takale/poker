package com.amaap.poker.domain.service.rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StraightFlush {
    public static boolean isStraightFlush(List<String> cards) {
        boolean isStraight = Straight.isStraight(cards);
        Map<Character, Integer> score = new HashMap<>();
        for (String card : cards) {
            char secondChar = card.charAt(0);
            score.put(secondChar, score.getOrDefault(secondChar, 0) + 1);
        }
        boolean isStraightFlush = score.containsValue(5);
        return (isStraight && isStraightFlush);
    }
}
