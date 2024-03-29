package com.amaap.poker.domain.service.rank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlushTest {

    @Test
    void shouldReturnTrueWhenValidFlushCardsPassed() {
        // arrange
        List<String> cards = Arrays.asList("H2", "H4", "H6", "H8", "HJ");
        // act
        boolean isFlush = Flush.isFlush(cards);
        // assert
        assertTrue(isFlush);
    }

    @Test
    void shouldReturnFalseWhenInvalidCardDeckPassed() {
        // arrange
        List<String> cards = Arrays.asList("H2", "H4", "S6", "H8", "HJ");
        // act
        boolean isFlush = Flush.isFlush(cards);
        // assert
        assertFalse(isFlush);
    }

    @Test
    void shouldReturnFalseWhenNotFlushCardsPassed() {
        // arrange
        List<String> cards = Arrays.asList("H2", "H4", "H6", "H8", "DJ");
        // act
        boolean isFlush = Flush.isFlush(cards);
        // assert
        assertFalse(isFlush);
    }
}
