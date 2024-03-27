package com.amaap.poker;

import com.amaap.poker.domain.Hand;
import com.amaap.poker.domain.service.HandEvaluator;
import com.amaap.poker.domain.service.exception.CardNotFoundException;
import com.amaap.poker.domain.service.exception.InvalidCardDeckException;

import java.util.Arrays;

public class PokerManager {
    private Hand hand;
    private HandEvaluator handEvaluator;

    public PokerManager(Hand hand, HandEvaluator handEvaluator) {
        this.hand = hand;
        this.handEvaluator = handEvaluator;

    }

    public boolean allocateCards() {
        hand.getCards().addAll(Arrays.asList("CK", "D7", "C7", "DK", "SA"));
        return true;
    }

    public String getBestHand() throws InvalidCardDeckException, CardNotFoundException {
        allocateCards();
        return handEvaluator.getBestHand(hand.getCards());
    }
}
