package com.amaap.poker.service;

import com.amaap.poker.PokerModule;
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
        cardService.create("H", "3");
        cardService.create("S", "3");
        cardService.create("H", "8");
        cardService.create("H", "4");
        cardService.create("H", "A");
        handService.create();

        // act
        String bestHand = pokerService.getBestHand();

        // assert
        assertEquals("Rank", bestHand);

    }

}