package com.amaap.poker.domain.service.rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Flush {
    public static boolean isFlush(List<String> cards) {
        Map<Character, Integer> score = new HashMap<>();
        for (String card : cards) {
            char secondChar = card.charAt(0);
            score.put(secondChar, score.getOrDefault(secondChar, 0) + 1);
        }
        return score.containsValue(5);
    }
}
