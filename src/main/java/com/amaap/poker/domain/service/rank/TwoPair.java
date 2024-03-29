package com.amaap.poker.domain.service.rank;

import java.util.List;
import java.util.Map;

public class TwoPair extends BestHandChecker {

    public static boolean isTwoPair(List<String> cards) {
        Map<Character, Integer> score = getRankFrequency(cards);
        int countOne = 0;
        int countTwo = 0;
        for (int value : score.values()) {
            if (value == 1) {
                countOne++;
            } else if (value == 2) countTwo++;
        }
        return countOne == 1 && countTwo == 2;

    }


}
