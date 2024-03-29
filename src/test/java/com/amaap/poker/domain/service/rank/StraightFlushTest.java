package com.amaap.poker.domain.service.rank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StraightFlushTest {

    @Test
    void shouldReturnTrueWhenValidStraightFlushCardsPassed() {
        // Arrange & Act
        List<String> straightFlushCards = Arrays.asList("H2", "H3", "H4", "H5", "H6");
        // Assert
        assertTrue(StraightFlush.isStraightFlush(straightFlushCards), "Expected straight flush");
    }

    @Test
    void shouldReturnFalseWhenInvalidCardDeckPassed() {
        // Arrange & Act
        List<String> notStraightFlushCards = Arrays.asList("H2", "D2", "S3", "C5", "H6");
        // Assert
        assertFalse(StraightFlush.isStraightFlush(notStraightFlushCards), "Expected not straight flush");
    }

    @Test
    void shouldReturnFalseWhenNotStraightFlushCardsPassed() {
        // Arrange & Act
        List<String> notStraightFlushCards = Arrays.asList("H2", "H3", "H4", "H5", "D6");
        // Assert
        assertFalse(StraightFlush.isStraightFlush(notStraightFlushCards), "Expected not straight flush");
    }
}
