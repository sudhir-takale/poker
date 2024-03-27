package com.amaap.poker;

import com.amaap.poker.domain.Hand;
import com.amaap.poker.domain.service.HandEvaluator;
import com.amaap.poker.domain.service.exception.CardNotFoundException;
import com.amaap.poker.domain.service.exception.InvalidCardDeckException;

import java.util.List;

public class PokerManager {
    private Hand hand;
    private HandEvaluator handEvaluator;

    public PokerManager(Hand hand, HandEvaluator handEvaluator) {
        this.hand = hand;
        this.handEvaluator = handEvaluator;
    }

    public List<String> allocateCards() {
        return hand.getCards();

    }

    public String getBestHand() throws InvalidCardDeckException, CardNotFoundException {
        List<String> cards = allocateCards();
        return handEvaluator.getBestHand(cards);
    }

}
