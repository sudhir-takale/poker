package com.amaap.poker.domain.service.handrank;

import com.amaap.poker.domain.model.entity.Card;
import com.amaap.poker.domain.model.entity.Hand;
import com.amaap.poker.domain.service.HandRankHandler;

import java.util.Collections;
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

        Collections.sort(cards, (c1, c2) -> getValueRank(c2.getValue()) - getValueRank(c1.getValue()));

        Card highestCard = cards.get(0);
        return "High Card " + highestCard.getValue();


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
