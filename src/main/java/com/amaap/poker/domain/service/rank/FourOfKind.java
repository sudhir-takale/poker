package com.amaap.poker.domain.service.rank;

import java.util.List;
import java.util.Map;


public class FourOfKind extends BestHandChecker{

    public static boolean isFourOfAKind(List<String> cards) {
        Map<Character, Integer> score = getRankFrequency(cards);

        return score.containsValue(4) && score.containsValue(1);
    }
}
