package com.amaap.poker;

import com.amaap.poker.config.Deck;
import com.amaap.poker.domain.Hand;
import com.amaap.poker.domain.service.HandEvaluator;
import com.amaap.poker.domain.service.exception.CardNotFoundException;
import com.amaap.poker.domain.service.exception.InvalidCardDeckException;

import java.util.Collections;
import java.util.List;

public class PokerManager {
    private Hand hand;
    private HandEvaluator handEvaluator;

    public PokerManager(Hand hand, HandEvaluator handEvaluator) {
        this.hand = hand;
        this.handEvaluator = handEvaluator;
    }

    public List<String> allocateCards() {

        Deck deck = new Deck();
        List<String> cards = deck.getCardDeck();
        List<String> handDeck = hand.getCards();
        Collections.shuffle(cards);
        for (int i = 0; i < 5; i++) {
            handDeck.add(cards.get(i));
            System.out.print(cards.get(i) + " ");
        }
        return hand.getCards();
    }

    public String getBestHand() throws InvalidCardDeckException, CardNotFoundException {
//        List<String> cards = allocateCards();
        return handEvaluator.getBestHand(hand.getCards());
    }

}
