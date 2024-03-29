package com.amaap.poker.domain.service.rank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FullHouseTest {

    @Test
    void shouldReturnTrueWhenValidFullHouseCardsPassed() {
        // Arrange & Act
        List<String> fullHouseCards = Arrays.asList("H2", "D2", "S2", "C3", "H3");
        // Assert
        assertTrue(FullHouse.isFullHouse(fullHouseCards), "Expected full house");
    }

    @Test
    void shouldReturnFalseWhenInvalidCardDeckPassed() {
        // Arrange & Act
        List<String> notFullHouseCards = Arrays.asList("H2", "D2", "S3", "C4", "H5");
        // Assert
        assertFalse(FullHouse.isFullHouse(notFullHouseCards), "Expected not full house");
    }

    @Test
    void shouldReturnFalseWhenNotFullHouseCardsPassed() {
        // Arrange & Act
        List<String> notFullHouseCards = Arrays.asList("H2", "D2", "S2", "C5", "H6");
        // Assert
        assertFalse(FullHouse.isFullHouse(notFullHouseCards), "Expected not full house");
    }
}
