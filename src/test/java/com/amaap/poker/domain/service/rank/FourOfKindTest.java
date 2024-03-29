package com.amaap.poker.domain.service.rank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FourOfKindTest {

    @Test
    void shouldReturnTrueWhenValidFourOfAKindCardsPassed() {
        // arrange
        List<String> cards = Arrays.asList("H2", "D2", "S2", "C2", "H6");
        // act
        boolean isFourOfAKind = FourOfKind.isFourOfAKind(cards);
        // assert
        assertTrue(isFourOfAKind);
    }

    @Test
    void shouldReturnFalseWhenInvalidCardDeckPassed() {
        // arrange
        List<String> cards = Arrays.asList("H2", "D2", "S3", "C4", "H5");
        // act
        boolean isFourOfAKind = FourOfKind.isFourOfAKind(cards);
        // assert
        assertFalse(isFourOfAKind);
    }

    @Test
    void shouldReturnFalseWhenNotFourOfAKindCardsPassed() {
        // arrange
        List<String> cards = Arrays.asList("H2", "D2", "S3", "C2", "H6");
        // act
        boolean isFourOfAKind = FourOfKind.isFourOfAKind(cards);
        // assert
        assertFalse(isFourOfAKind);
    }
}
