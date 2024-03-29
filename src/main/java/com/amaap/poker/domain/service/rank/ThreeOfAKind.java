package com.amaap.poker.domain.service.rank;

import java.util.List;
import java.util.Map;


public class ThreeOfAKind extends BestHandChecker{
    public static boolean isThreeOfAKind(List<String> cards) {
        Map<Character, Integer> score = getRankFrequency(cards);
        int countThree = 0;
        for (int count : score.values()) {
            if (count == 3) {
                countThree++;
            }
        }
        return countThree == 1;
    }
}
