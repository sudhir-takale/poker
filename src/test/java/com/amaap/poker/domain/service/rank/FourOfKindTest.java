package com.amaap.poker.domain.service.rank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FourOfKindTest {

    @Test
    void shouldReturnTrueWhenValidFourOfAKindCardsPassed() {
        // arrange
        List<String> fourOfAKindCards = Arrays.asList("H2", "D2", "S2", "C2", "H6");
        // act
        boolean isFourOfAKind = FourOfKind.isFourOfAKind(fourOfAKindCards);
        // assert
        assertTrue(isFourOfAKind, "Expected four of a kind");
    }

    @Test
    void shouldReturnFalseWhenInvalidCardDeckPassed() {
        // arrange
        List<String> invalidCards = Arrays.asList("H2", "D2", "S3", "C4", "H5");
        // act
        boolean isFourOfAKind = FourOfKind.isFourOfAKind(invalidCards);
        // assert
        assertFalse(isFourOfAKind, "Expected not four of a kind");
    }

    @Test
    void shouldReturnFalseWhenNotFourOfAKindCardsPassed() {
        // arrange
        List<String> notFourOfAKindCards = Arrays.asList("H2", "D2", "S3", "C2", "H6");
        // act
        boolean isFourOfAKind = FourOfKind.isFourOfAKind(notFourOfAKindCards);
        // assert
        assertFalse(isFourOfAKind, "Expected not four of a kind");
    }
}
