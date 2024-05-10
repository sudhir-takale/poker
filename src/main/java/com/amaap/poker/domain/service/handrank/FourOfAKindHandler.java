package com.amaap.poker.domain.service.handrank;

import com.amaap.poker.domain.model.entity.Hand;
import com.amaap.poker.domain.service.HandRankHandler;

public class FourOfAKindHandler implements HandRankHandler {
    private HandRankHandler successor;

    @Override
    public void setSuccessor(HandRankHandler successor) {
        this.successor = successor;

    }

    @Override
    public String evaluateHand(Hand hand) {
        return "";
    }
}
