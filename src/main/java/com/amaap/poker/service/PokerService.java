package com.amaap.poker.service;

import com.amaap.poker.domain.model.entity.Hand;
import com.amaap.poker.domain.service.BestHandEvaluator;
import com.google.inject.Inject;

import java.util.List;

public class PokerService {

    private final HandService handService;

    @Inject
    public PokerService(HandService handService) {
        this.handService = handService;
    }

    public String getBestHand() {
        List<Hand> hands = handService.getAllHand();
        for (Hand hand : hands) {

            return BestHandEvaluator.evaluateHand(hand);
        }
        return "High Card";
    }
}
