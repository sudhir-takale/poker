package com.amaap.poker;

import com.amaap.poker.domain.Hand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class PokerManagerTest {
    private Hand hand;
    private PokerManager pokerManager;

    public PokerManagerTest() {
        hand = new Hand();
        pokerManager = new PokerManager(hand);
    }

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
//        act
        boolean result = pokerManager.allocateCards();
        List<String> expectedCards = hand.getCards();
        List<String> actualCards = Arrays.asList("CK", "D7", "C7", "DK", "SA");
//        assert
        Assertions.assertTrue(result);
        Assertions.assertEquals(actualCards, expectedCards);
        Assertions.assertEquals(5, expectedCards.size());

    }





}
