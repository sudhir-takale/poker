package com.amaap.poker.controller;

import com.amaap.poker.controller.dto.HttpStatus;
import com.amaap.poker.controller.dto.Response;

public class CardController {
    public Response create(String suit, String value) {
        return new Response(HttpStatus.OK, "success");
    }
}
