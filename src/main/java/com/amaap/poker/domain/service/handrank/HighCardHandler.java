package com.amaap.poker.domain.service.handrank;

import com.amaap.poker.domain.model.entity.Card;
import com.amaap.poker.domain.model.entity.Hand;
import com.amaap.poker.domain.service.HandRankHandler;

import java.util.List;

public class HighCardHandler implements HandRankHandler {
    private HandRankHandler successor;

    @Override
    public void setSuccessor(HandRankHandler successor) {
        this.successor = successor;

    }

    @Override
    public String evaluateHand(Hand hand) {
        List<Card> cards = hand.getCards();

        return "";
    }
}
