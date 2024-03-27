package com.amaap.poker.domain.service;

import com.amaap.poker.domain.service.exception.CardNotFoundException;
import com.amaap.poker.domain.service.exception.InvalidCardDeckException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class HandEvaluatorTest {
    HandEvaluator handEvaluator = new HandEvaluator();

    @Test
    void shouldThrowCardNotFoundExceptionWhenListOfCardsIsEmpty() {
//       act & assert
        Assertions.assertThrows(CardNotFoundException.class, () -> {
            handEvaluator.getBestHand(new ArrayList<>());
        }, "Card Deck can't be Empty !");

    }

    @Test
    void shouldThrowInvalidCardDeckExceptionWhenListOfCardsIsEmpty() {
//       act & assert
        Assertions.assertThrows(InvalidCardDeckException.class, () -> {
            handEvaluator.getBestHand(new ArrayList<>());
        }, "Card Deck is not Valid check number of cards!");

    }


    @Test
    void shouldBeAbleToGetBestHand() throws CardNotFoundException, InvalidCardDeckException {
//        act
        String bestHand = handEvaluator.getBestHand(Arrays.asList("S1", "S2", "S3", "S4", "S5"));
//        assert
        Assertions.assertEquals("full-house", bestHand);
    }


}