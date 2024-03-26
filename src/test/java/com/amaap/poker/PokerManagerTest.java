package com.amaap.poker;

import com.amaap.poker.domain.Hand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PokerManagerTest {

    @Test
    void shouldBeAbleToCreateHand() {
//        arrange & act
        Hand hand = new Hand();
//        assert
        Assertions.assertNotNull(hand);

    }

    @Test
    void shouldBeAbleToEmptyListOfCardsOfHand() {
//        arrange
        Hand hand = new Hand();
//        act
        List<String> expectedCards = hand.getCards();
//        assert
        Assertions.assertTrue(expectedCards.isEmpty());
    }


}
