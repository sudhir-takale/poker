package com.amaap.poker.domain.service.rank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StraightTest {

    @Test
    void shouldReturnTrueWhenValidStraightCardsPassed() {
        // arrange & act
        List<String> cards = Arrays.asList("H2", "D3", "S4", "C5", "H6");
        // assert
        assertTrue(Straight.isStraight(cards));
    }

    @Test
    void shouldReturnFalseWhenInvalidCardDeckPassed() {
        // arrange & act
        List<String> cards = Arrays.asList("H2", "D2", "S3", "C5", "H6");
        // assert
        assertFalse(Straight.isStraight(cards));
    }


}
