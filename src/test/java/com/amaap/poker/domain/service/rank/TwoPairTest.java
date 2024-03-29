package com.amaap.poker.domain.service.rank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.amaap.poker.domain.service.rank.BestHandChecker.getRankFrequency;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TwoPairTest {

    @Test
    void shouldReturnTrueWhenValidTwoPairCardsPassed() {
//        arrange & act
        List<String> card = Arrays.asList("H2", "D2", "S3", "C3", "H4");
        Map<Character, Integer> score = getRankFrequency(card);
        int countOne = 0;
        int countTwo = 0;
        for (int value : score.values()) {
            if (value == 1) {
                countOne++;
            } else if (value == 2) countTwo++;
        }
//        assert;
        assertTrue(TwoPair.isTwoPair(card));
        Assertions.assertEquals(1, countOne);
        Assertions.assertEquals(2, countTwo);
    }

    @Test
    void shouldReturnFalseWhenInvalidCardDeckPassed() {
//        arrange & act
        List<String> cards = Arrays.asList("H2", "D2", "S3", "C4", "H5");
//        assert
        assertFalse(TwoPair.isTwoPair(cards));
    }

    @Test
    void shouldReturnFalseWhenInvalidCardRankPassed() {
//        arrange & act
        List<String> cards = Arrays.asList("H2", "D3", "S4", "C5", "H6");
//        assert
        assertFalse(TwoPair.isTwoPair(cards));
    }

}
