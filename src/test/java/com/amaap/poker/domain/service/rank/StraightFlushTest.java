package com.amaap.poker.domain.service.rank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StraightFlushTest {

    @Test
    void shouldReturnTrueWhenValidStraightFlushCardsPassed() {
        // arrange & act
        List<String> cards = Arrays.asList("H2", "H3", "H4", "H5", "H6");
        // assert
        assertTrue(StraightFlush.isStraightFlush(cards));
    }

    @Test
    void shouldReturnFalseWhenInvalidCardDeckPassed() {
        // arrange & act
        List<String> cards = Arrays.asList("H2", "D2", "S3", "C5", "H6");
        // assert
        assertFalse(StraightFlush.isStraightFlush(cards));
    }

    @Test
    void shouldReturnFalseWhenNotStraightFlushCardsPassed() {
        // arrange & act
        List<String> cards = Arrays.asList("H2", "H3", "H4", "H5", "D6");
        // assert
        assertFalse(StraightFlush.isStraightFlush(cards));
    }
}
