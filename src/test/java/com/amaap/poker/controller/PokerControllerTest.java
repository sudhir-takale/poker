package com.amaap.poker.controller;

import com.amaap.poker.PokerModule;
import com.amaap.poker.domain.model.valueobject.Rank;
import com.amaap.poker.service.CardService;
import com.amaap.poker.service.exception.InvalidCardException;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokerControllerTest {

    @Inject
    PokerController pokerController;

    @Inject
    CardService cardService;

    @Inject
    HandController handController;

    @BeforeEach
    void setup() {
        Injector injector = Guice.createInjector(new PokerModule());
        pokerController = injector.getInstance(PokerController.class);
        cardService = injector.getInstance(CardService.class);
        handController = injector.getInstance(HandController.class);
    }


    @Test
    void shouldBeAbleToGetBestHand() throws InvalidCardException {
        // arrange
        cardService.create("D", "5");
        cardService.create("D", "2");
        cardService.create("D", "7");
        cardService.create("D", "T");
        cardService.create("D", "A");
        handController.create();

        // act
        Rank bestHand = pokerController.getBestHand();

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
        handController.create();

        // act
        Rank bestHand = pokerController.getBestHand();

        // assert
        assertEquals(Rank.STRAIGHT, bestHand);
    }
}
