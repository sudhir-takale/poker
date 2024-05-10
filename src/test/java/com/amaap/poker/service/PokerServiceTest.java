package com.amaap.poker.service;

import com.amaap.poker.PokerModule;
import com.amaap.poker.domain.model.valueobject.Rank;
import com.amaap.poker.service.exception.InvalidCardException;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PokerServiceTest {

    @Inject
    CardService cardService;

    @Inject
    HandService handService;

    @Inject
    PokerService pokerService;

    @BeforeEach
    void setup() {
        Injector injector = Guice.createInjector(new PokerModule());
        cardService = injector.getInstance(CardService.class);
        handService = injector.getInstance(HandService.class);
        pokerService = injector.getInstance(PokerService.class);
    }

    @Test
    void shouldBeAbleToEvaluateBestHand() throws InvalidCardException {
        // arrange
        cardService.create("D", "5");
        cardService.create("S", "2");
        cardService.create("C", "7");
        cardService.create("S", "T");
        cardService.create("H", "A");
        handService.create();

        // act
        Rank bestHand = pokerService.getBestHand();

        // assert
        assertEquals(Rank.HIGHCARD, bestHand);

    }
    @Test
    void shouldBeAbleToEvaluateBestHandAsFlush() throws InvalidCardException {
        // arrange
        cardService.create("D", "5");
        cardService.create("D", "2");
        cardService.create("D", "7");
        cardService.create("D", "T");
        cardService.create("D", "A");
        handService.create();

        // act
        Rank bestHand = pokerService.getBestHand();

        // assert
        assertEquals(Rank.FLUSH, bestHand);
    }

    @Test
    void shouldBeAbleToEvaluateBestHandAsStraight() throws InvalidCardException {
        // arrange
        cardService.create("D", "2");
        cardService.create("H", "3");
        cardService.create("C", "4");
        cardService.create("S", "5");
        cardService.create("H", "6");
        handService.create();

        // act
        Rank bestHand = pokerService.getBestHand();

        // assert
        assertEquals(Rank.STRAIGHT, bestHand);
    }






}