package com.amaap.poker.domain.service.rank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PairTest {

    @Test
    void shouldReturnTrueWhenValidPairCardsPassed() {
        // Arrange & Act
        List<String> pairCards = Arrays.asList("H2", "D2", "S3", "C4", "H5");
        // Assert
        assertTrue(Pair.isPair(pairCards), "Expected pair");
    }

    @Test
    void shouldReturnFalseWhenInvalidCardDeckPassed() {
        // Arrange & Act
        List<String> notPairCards = Arrays.asList("H2", "D3", "S4", "C5", "H6");
        // Assert
        assertFalse(Pair.isPair(notPairCards), "Expected not pair");
    }

    @Test
    void shouldReturnFalseWhenNotPairCardsPassed() {
        // Arrange & Act
        List<String> notPairCards = Arrays.asList("H2", "D2", "S2", "C3", "H3");
        // Assert
        assertFalse(Pair.isPair(notPairCards), "Expected not pair");
    }
}
