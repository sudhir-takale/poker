package com.amaap.poker.domain.service.rank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ThreeOfAKindTest {

    @Test
    void shouldReturnTrueWhenValidThreeOfAKindCardsPassed() {
        // arrange
        List<String> cards = Arrays.asList("HA", "DA", "SA", "S3", "C6");
        // act
        boolean isThreeOfAKind = ThreeOfAKind.isThreeOfAKind(cards);
        // assert
        assertTrue(isThreeOfAKind);
    }

    @Test
    void shouldReturnFalseWhenInvalidCardDeckPassed() {
        // arrange
        List<String> cards = Arrays.asList("HA", "DA", "S3", "C4", "H5");
        // act
        boolean isThreeOfAKind = ThreeOfAKind.isThreeOfAKind(cards);
        // assert
        assertFalse(isThreeOfAKind);
    }


}
