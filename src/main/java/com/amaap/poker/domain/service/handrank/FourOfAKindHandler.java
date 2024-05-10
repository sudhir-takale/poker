package com.amaap.poker.domain.service.handrank;

import com.amaap.poker.domain.model.entity.Card;
import com.amaap.poker.domain.model.entity.Hand;
import com.amaap.poker.domain.model.valueobject.Rank;
import com.amaap.poker.domain.service.HandRankHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourOfAKindHandler implements HandRankHandler {
    private HandRankHandler successor;

    @Override
    public void setSuccessor(HandRankHandler successor) {
        this.successor = successor;

    }

    @Override
    public Rank evaluateHand(Hand hand) {
        List<Card> cards = hand.getCards();

        Map<String, Integer> valueCounts = new HashMap<>();
        for (Card card : cards) {
            String value = card.getValue();
            valueCounts.put(value, valueCounts.getOrDefault(value, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : valueCounts.entrySet()) {
            if (entry.getValue() == 4) {
                return Rank.FOUROFAKIND;
            }
        }

        return successor.evaluateHand(hand);
    }
}

