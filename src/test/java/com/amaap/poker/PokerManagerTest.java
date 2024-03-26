package com.amaap.poker;

import com.amaap.poker.domain.Hand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class PokerManagerTest {
    Hand hand = new Hand();

    @Test
    void shouldBeAbleToCreateHand() {
//        arrange & act
        Hand hand = new Hand();
//        assert
        Assertions.assertNotNull(hand);

    }

    @Test
    void shouldBeAbleToEmptyListOfCardsOfHand() {
//        act
        List<String> expectedCards = hand.getCards();
//        assert
        Assertions.assertTrue(expectedCards.isEmpty());
    }

    @Test
    void shouldBeAbleToAddCardsInCardsList() {
//        act
        hand.getCards().add("D8");
        hand.getCards().add("CK");
        List<String> expectedCards = hand.getCards();
//        assert
        Assertions.assertEquals(2, expectedCards.size());
        Assertions.assertEquals(Arrays.asList("D8", "CK"), expectedCards);

    }

//    @Test
//    void shouldThrowInvalidCardCountExceptionIfCardsAreNotExactlyFive() {
//        hand.getCards().add("D8");
//        hand.getCards().add("CK");
//        hand.getCards().add("CK");
//        hand.getCards().add("CK");
////        act
//        List<String> expectedCards = hand.getCards();
////        assert
//        Assertions.assertEquals(2, expectedCards.size());
//        Assertions.assertEquals(Arrays.asList("D8", "CK"), expectedCards);
//
//    }


    @Test
    void shouldBeAbleToAllocateCardToHand() {
//      arrange
        PokerManager pokerManager = new PokerManager();
//        act
        boolean result = pokerManager.allocateCards();
//        assert
        Assertions.assertTrue(result);
    }


}
