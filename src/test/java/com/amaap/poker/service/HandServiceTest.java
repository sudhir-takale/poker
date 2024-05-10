package com.amaap.poker.service;

import com.amaap.poker.PokerModule;
import com.amaap.poker.domain.model.entity.Hand;
import com.amaap.poker.service.exception.InvalidCardException;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HandServiceTest {

    @Inject
    CardService cardService;

    @Inject
    HandService handService;


    @BeforeEach
    public void setup() {
        Injector injector = Guice.createInjector(new PokerModule());
        cardService = injector.getInstance(CardService.class);
        handService = injector.getInstance(HandService.class);
    }

    @Test
    void shouldBeAbleToCreateAHand() throws InvalidCardException {
        // arrange
        cardService.create("H", "4");
        cardService.create("H", "2");
        cardService.create("H", "5");
        cardService.create("H", "7");
        cardService.create("H", "8");
        cardService.create("H", "2");

        // act
        Hand hand = handService.create();

        // assert
        assertEquals("H", hand.getCards().get(0).getSuit());

    }

    @Test
    void shouldBeAbleToGetAllHands() {
        // arrange
        Hand hand = handService.create();
        handService.create();

        // act
        List<Hand> hands = handService.getAllHand();

        // assert
        assertEquals(2, hands.size());

    }

}