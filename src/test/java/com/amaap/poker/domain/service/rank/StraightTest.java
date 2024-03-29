package com.amaap.poker.domain.service.rank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StraightTest {

    @Test
    void shouldReturnTrueWhenValidStraightCardsPassed() {
        // Arrange & Act
        List<String> straightCards = Arrays.asList("H2", "D3", "S4", "C5", "H6");
        // Assert
        assertTrue(Straight.isStraight(straightCards), "Expected straight");
    }

    @Test
    void shouldReturnFalseWhenInvalidCardDeckPassed() {
        // Arrange & Act
        List<String> notStraightCards = Arrays.asList("H2", "D2", "S3", "C5", "H6");
        // Assert
        assertFalse(Straight.isStraight(notStraightCards), "Expected not straight");
    }

    @Test
    void shouldReturnFalseWhenNotStraightCardsPassed() {
        // Arrange & Act
        List<String> notStraightCards = Arrays.asList("H2", "D3", "S4", "C5", "H7");
        // Assert
        assertFalse(Straight.isStraight(notStraightCards), "Expected not straight");
    }
}
