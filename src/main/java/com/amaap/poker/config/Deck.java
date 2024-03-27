package com.amaap.poker.config;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    private List<String> cardDeck;

    public Deck() {
        this.cardDeck = new ArrayList<>();
        populateDeck();
    }

    private void populateDeck() {
        String[] suits = {"H", "D", "C", "S"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (String suit : suits) {
            for (String rank : ranks) {
                String card = suit + rank;
                cardDeck.add(card);
            }
        }
    }

    public List<String> getCardDeck() {
        return cardDeck;
    }
}
