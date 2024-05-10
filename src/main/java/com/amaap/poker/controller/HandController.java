package com.amaap.poker.controller;

import com.amaap.poker.controller.dto.HttpStatus;
import com.amaap.poker.controller.dto.Response;
import com.amaap.poker.domain.model.entity.Hand;
import com.amaap.poker.service.HandService;
import com.google.inject.Inject;

import java.util.List;

public class HandController {
    private final HandService handService;


    @Inject
    public HandController(HandService handService) {
        this.handService = handService;
    }

    public Response create() {
        handService.create();
        return new Response(HttpStatus.OK, "success");

    }

    public List<Hand> getHands() {
        return handService.getAllHand();
    }
}
