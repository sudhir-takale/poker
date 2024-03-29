package com.amaap.poker.domain.service.rank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HighCardTest {

    @Test
    void shouldReturnKingAsAHighCardWhenValidCardIsPassed() {
//         arrange
        List<String> cards = Arrays.asList("H2", "D3", "S4", "C5", "HK");
//         act
        String highCard = HighCard.getHighCard(cards);
//         assert
        assertEquals("king", highCard, "Expected king as high card");
    }


    @Test
    void shouldReturnCorrectHighCardWhenValidDeckIsPassed() {
//         arrange
        List<String> cards = Arrays.asList("H2", "D3", "S4", "C5", "HT");
//         act
        String highCard = HighCard.getHighCard(cards);
//         assert
        assertEquals("ten", highCard, "Expected ten as high card");
    }

    @Test
    void shouldReturnKingWhenValidCharacterIsPassed() {
//        arrange & act
        String highcard = HighCard.getBestHighCard('K');
//        assert
        assertEquals("king", highcard);
    }

    @Test
    void shouldReturnQueenWhenValidCharacterIsPassed() {
//        arrange & act
        String highcard = HighCard.getBestHighCard('Q');
//        assert
        assertEquals("queen", highcard);
    }

    @Test
    void shouldReturnJackWhenValidCharacterIsPassed() {
//        arrange & act
        String highcard = HighCard.getBestHighCard('J');
//        assert
        assertEquals("jack", highcard);
    }

    @Test
    void shouldReturnTenWhenValidCharacterIsPassed() {
//        arrange & act
        String highcard = HighCard.getBestHighCard('T');
//        assert
        assertEquals("ten", highcard);
    }

    @Test
    void shouldReturnEightWhenValidCharacterIsPassed() {
//        arrange & act
        String highcard = HighCard.getBestHighCard('8');
//        assert
        assertEquals("8", highcard);
    }

}
