package com.amaap.poker.domain.service.handrank;

import com.amaap.poker.domain.model.entity.Card;
import com.amaap.poker.domain.model.entity.Hand;
import com.amaap.poker.domain.service.HandRankHandler;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FlushHandler implements HandRankHandler {
    private HandRankHandler successor;

    @Override
    public void setSuccessor(HandRankHandler successor) {
        this.successor = successor;

    }

    @Override
    public String evaluateHand(Hand hand) {
        List<Card> cards = hand.getCards();

        Set<String> suits = new HashSet<>();
        for (Card card : cards) {
            suits.add(card.getSuit());
        }

        if (suits.size() == 1) {
            return "Flush";
        } else {
            return successor.evaluateHand(hand);
        }
    }
}
