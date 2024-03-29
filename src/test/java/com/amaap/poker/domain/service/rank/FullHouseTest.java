package com.amaap.poker.domain.service.rank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FullHouseTest {

    @Test
    void shouldReturnTrueWhenValidFullHouseCardsPassed() {
        // arrange & act
        List<String> cards = Arrays.asList("H2", "D2", "S2", "C3", "H3");
        // assert
        assertTrue(FullHouse.isFullHouse(cards));
    }

    @Test
    void shouldReturnFalseWhenInvalidCardDeckPassed() {
        // arrange & act
        List<String> cards = Arrays.asList("H2", "D2", "S3", "C4", "H5");
        // assert
        assertFalse(FullHouse.isFullHouse(cards));
    }

    @Test
    void shouldReturnFalseWhenNotFullHouseCardsPassed() {
        // arrange & act
        List<String> cards = Arrays.asList("H2", "D2", "S2", "C5", "H6");
        // assert
        assertFalse(FullHouse.isFullHouse(cards));
    }
}
