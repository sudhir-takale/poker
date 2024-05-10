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

public class HandControllerTest {

    @Inject
    HandController handController;

    @BeforeEach
    public void setUp() {
        Injector injector = Guice.createInjector(new PokerModule());
        handController = injector.getInstance(HandController.class);
    }


    @Test
    void shouldBeAbleToCreateHand() {
        // arrange
        Response expected = new Response(HttpStatus.OK, "success");

        // act
        Response actual = handController.create();

        // assert
        assertEquals(expected, actual);
    }


}
