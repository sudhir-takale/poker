package com.amaap.poker.controller;

import com.amaap.poker.PokerModule;
import com.amaap.poker.controller.dto.HttpStatus;
import com.amaap.poker.controller.dto.Response;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardControllerTest {


    @Inject
    CardController cardController;

    @BeforeEach
    public void setUp() {
        Injector injector = Guice.createInjector(new PokerModule());
        cardController = injector.getInstance(CardController.class);
    }


    @Test
    void shouldBeAbleToCreateACard() {
        // arrange
        String suit = "H";
        String value = "5";
        Response expected = new Response(HttpStatus.OK, "success");

        // act
        Response actual = cardController.create(suit, value);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnBadRequestIfSuitIsInvalid() {
        // arrange
        String suit = "";
        String value = "5";
        Response expected = new Response(HttpStatus.BAD_REQUEST, "failed");

        // act
        Response actual = cardController.create(suit, value);

        // assert
        assertEquals(expected, actual);
    }

}
