package com.amaap.poker.domain.service.handrank;

import com.amaap.poker.domain.model.entity.Card;
import com.amaap.poker.domain.model.entity.Hand;
import com.amaap.poker.domain.model.valueobject.Rank;
import com.amaap.poker.domain.service.HandRankHandler;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StraightHandler implements HandRankHandler {
    private HandRankHandler successor;

    @Override
    public void setSuccessor(HandRankHandler successor) {
        this.successor = successor;

    }

    @Override
    public Rank evaluateHand(Hand hand) {

        List<Card> cards = hand.getCards();

        Collections.sort(cards, (c1, c2) -> getValueRank(c1.getValue()) - getValueRank(c2.getValue()));

        Set<Integer> rankSet = new HashSet<>();
        for (Card card : cards) {
            rankSet.add(getValueRank(card.getValue()));
        }

        if (rankSet.size() == 5) {
            boolean isConsecutive = true;
            for (int i = 0; i < cards.size() - 1; i++) {
                if (getValueRank(cards.get(i + 1).getValue()) - getValueRank(cards.get(i).getValue()) != 1) {
                    isConsecutive = false;
                    break;
                }
            }
            if (isConsecutive) {
                return Rank.STRAIGHT;
            }
        }
        return successor.evaluateHand(hand);
    }


    private int getValueRank(String value) {
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};
        for (int i = 0; i < values.length; i++) {
            if (values[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }


}


