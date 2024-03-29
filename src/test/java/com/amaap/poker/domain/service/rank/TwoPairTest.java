package com.amaap.poker.domain.service.rank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TwoPairTest {

    @Test
    void shouldReturnTrueWhenValidTwoPairCardsPassed() {
//        arrange & act
        List<String> twoPairCards = Arrays.asList("H2", "D2", "S3", "C3", "H4");
//        assert;
        assertTrue(TwoPair.isTwoPair(twoPairCards));
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
