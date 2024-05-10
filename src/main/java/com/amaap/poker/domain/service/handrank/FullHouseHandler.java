package com.amaap.poker.domain.service.handrank;

import com.amaap.poker.domain.model.entity.Card;
import com.amaap.poker.domain.model.entity.Hand;
import com.amaap.poker.domain.model.valueobject.Rank;
import com.amaap.poker.domain.service.HandRankHandler;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FullHouseHandler implements HandRankHandler {
    private HandRankHandler successor;

    @Override
    public void setSuccessor(HandRankHandler successor) {
        this.successor = successor;

    }

    @Override
    public Rank evaluateHand(Hand hand) {
        List<Card> cards = hand.getCards();
        Map<String, Long> valueCounts = cards.stream().collect(Collectors.groupingBy(Card::getValue, Collectors.counting()));

        boolean hasThreeOfAKind = false;
        boolean hasPair = false;

        for (Map.Entry<String, Long> entry : valueCounts.entrySet()) {
            if (entry.getValue() == 3) {
                hasThreeOfAKind = true;
            } else if (entry.getValue() == 2) {
                hasPair = true;
            }
        }

        if (hasThreeOfAKind && hasPair) {
            return Rank.FULLHOUSE;
        } else {
            return successor.evaluateHand(hand);
        }
    }
}

