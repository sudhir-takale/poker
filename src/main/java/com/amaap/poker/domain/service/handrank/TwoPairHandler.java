package com.amaap.poker.domain.service.handrank;

import com.amaap.poker.domain.model.entity.Card;
import com.amaap.poker.domain.model.entity.Hand;
import com.amaap.poker.domain.service.HandRankHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoPairHandler implements HandRankHandler {
    private HandRankHandler successor;

    @Override
    public void setSuccessor(HandRankHandler successor) {
        this.successor = successor;

    }

    @Override
    public String evaluateHand(Hand hand) {
        List<Card> cards = hand.getCards();

        Map<String, Integer> valueCounts = new HashMap<>();
        for (Card card : cards) {
            String value = card.getValue();
            valueCounts.put(value, valueCounts.getOrDefault(value, 0) + 1);
        }

        int pairCount = 0;
        for (int count : valueCounts.values()) {
            if (count == 2) {
                pairCount++;
            }
        }

        if (pairCount == 2) {
            return "Two Pair";
        } else {
            return successor.evaluateHand(hand);
        }

    }
}
