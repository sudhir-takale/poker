package com.amaap.poker.domain.service;

import com.amaap.poker.domain.Hand;
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
        Assertions.assertThrows(CardNotFoundException.class, () -> handEvaluator.getBestHand(new ArrayList<>()), "Card Deck can't be Empty !");
    }

    @Test
    void shouldThrowInvalidCardDeckExceptionWhenListOfCardsIsEmpty() {
//       act & assert
        Assertions.assertThrows(InvalidCardDeckException.class, () -> handEvaluator.getBestHand(Arrays.asList("S2", "D5", "HA")), "Card Deck is not Valid, check number of cards!");
    }

    @Test
    void shouldBeAbleToGetHighHandForCorrectInput() throws CardNotFoundException, InvalidCardDeckException {
//        act
        String bestHand = handEvaluator.getBestHand(Arrays.asList("S2", "D5", "C7", "ST", "HA"));
//        assert
        Assertions.assertEquals("high-card-ace", bestHand);
    }

    @Test
    void shouldBeAbleToGetCorrectBestHandIfCardAreIsStraight() throws InvalidCardDeckException, CardNotFoundException {
//        act
        String bestHand = handEvaluator.getBestHand(Arrays.asList("D1", "S2", "S3", "S4", "S5"));
//        assert
        Assertions.assertEquals("straight", bestHand);
    }

    @Test
    void shouldBeAbleToGetCorrectBestHandIfHandIsStraightFlush() throws InvalidCardDeckException, CardNotFoundException {
//        act
        String bestHand = handEvaluator.getBestHand(Arrays.asList("S1", "S2", "S3", "S4", "S5"));
//        assert
        Assertions.assertEquals("straight-flush", bestHand);
    }

    @Test
    void shouldBeAbleToGetCorrectBestHandIfHandIsFlush() throws InvalidCardDeckException, CardNotFoundException {
//         act
        String bestHand = handEvaluator.getBestHand(Arrays.asList("D2", "D2", "D3", "D4", "D5"));
//        assert
        Assertions.assertEquals("flush", bestHand);
    }

    @Test
    void shouldBeAbleToGetCorrectBestHandIfHandIsFullHouse() throws InvalidCardDeckException, CardNotFoundException {
//        act
        String bestHand = handEvaluator.getBestHand(Arrays.asList("D2", "S2", "D3", "D3", "D3"));
//        assert
        Assertions.assertEquals("full-house", bestHand);
    }

    @Test
    void shouldBeAbleToGetCorrectBestHandIfHandIsAPair() throws InvalidCardDeckException, CardNotFoundException {
//        act
        String bestHand = handEvaluator.getBestHand(Arrays.asList("D2", "S2", "DA", "DK", "DJ"));
//        assert
        Assertions.assertEquals("pair", bestHand);
    }

    @Test
    void shouldBeAbleToGetCorrectBestHandIsFourOfKind() throws InvalidCardDeckException, CardNotFoundException {
//        act
        String bestHand = handEvaluator.getBestHand(Arrays.asList("D2", "S2", "D2", "D2", "DJ"));
//        assert
        Assertions.assertEquals("four-of-a-kind", bestHand);
    }

    @Test
    void shouldBeAbleToGetCorrectBestHandIsThreeOfKind() throws InvalidCardDeckException, CardNotFoundException {
//        act
        String bestHand = handEvaluator.getBestHand(Arrays.asList("D2", "S2", "D2", "DA", "DJ"));
//        assert
        Assertions.assertEquals("three-of-a-kind", bestHand);
    }

    @Test
    void shouldBeAbleToGetCorrectBestHandIsTwoPair() throws InvalidCardDeckException, CardNotFoundException {
//         act
        String bestHand = handEvaluator.getBestHand(Arrays.asList("D2", "S2", "D4", "D4", "DJ"));
//        assert
        Assertions.assertEquals("two-pair", bestHand);
    }

}