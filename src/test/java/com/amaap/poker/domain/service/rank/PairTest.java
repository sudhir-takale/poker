package com.amaap.poker.domain.service.rank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PairTest {

    @Test
    void shouldReturnTrueWhenValidPairCardsPassed() {
        // arrange & act
        List<String> cards = Arrays.asList("H2", "D2", "S3", "C4", "H5");
        // assert
        assertTrue(Pair.isPair(cards));
    }

    @Test
    void shouldReturnFalseWhenInvalidCardDeckPassed() {
        // arrange & act
        List<String> cards = Arrays.asList("H2", "D3", "S4", "C5", "H6");
        // assert
        assertFalse(Pair.isPair(cards));
    }

    @Test
    void shouldReturnFalseWhenNotPairCardsPassed() {
        // arrange & act
        List<String> cards = Arrays.asList("H2", "D2", "S2", "C3", "H3");
        // assert
        assertFalse(Pair.isPair(cards));
    }
}
