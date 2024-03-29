package com.amaap.poker.domain.service.rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestHandChecker {
    protected static Map<Character, Integer> getRankFrequency(List<String> cards) {
        Map<Character, Integer> score = new HashMap<>();
        for (String card : cards) {
            char secondChar = card.charAt(1);
            score.put(secondChar, score.getOrDefault(secondChar, 0) + 1);
        }
        return score;
    }
}
