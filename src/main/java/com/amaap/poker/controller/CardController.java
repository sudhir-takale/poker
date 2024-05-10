package com.amaap.poker.controller;

import com.amaap.poker.controller.dto.HttpStatus;
import com.amaap.poker.controller.dto.Response;
import com.amaap.poker.service.CardService;
import com.amaap.poker.service.exception.InvalidCardException;
import com.google.inject.Inject;

public class CardController {

    private final CardService cardservice;

    @Inject
    public CardController(CardService cardservice) {
        this.cardservice = cardservice;
    }

    public Response create(String suit, String value) {
        try {
            cardservice.create(suit, value);
            return new Response(HttpStatus.OK, "success");
        } catch (InvalidCardException e) {
            return new Response(HttpStatus.BAD_REQUEST, "failed");
        }

    }
}
