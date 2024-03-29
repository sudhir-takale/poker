package com.amaap.poker.domain.service.rank;

import java.util.List;
import java.util.Map;

public class Pair extends BestHandChecker{

    public static boolean isPair(List<String> cards) {
        Map<Character, Integer> score = getRankFrequency(cards);
        int countOne = 0;
        int countTwo = 0;
        for (int value : score.values()) {
            if (value == 1) {
                countOne++;
            } else if (value == 2) countTwo++;
        }
        return countOne == 3 && countTwo == 1;
    }
}
