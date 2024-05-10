package com.amaap.poker.controller;

import com.amaap.poker.domain.model.valueobject.Rank;
import com.amaap.poker.service.PokerService;
import com.google.inject.Inject;

public class PokerController {

    private final PokerService pokerService;

    @Inject
    public PokerController(PokerService pokerService) {
        this.pokerService = pokerService;
    }

    public Rank getBestHand() {
        return pokerService.getBestHand();
    }
}
