package com.amaap.poker.domain.service.rank;

import java.util.List;
import java.util.Map;


public class FullHouse extends BestHandChecker{
    public static boolean isFullHouse(List<String> cards) {
        Map<Character, Integer> score = getRankFrequency(cards);
        return score.containsValue(2) && score.containsValue(3);
    }
}
