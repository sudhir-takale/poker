package com.amaap.poker.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private static Hand hand;
    private List<String> cards;

    private Hand() {

        cards = new ArrayList<>();
    }

    public static synchronized Hand getInstance() {
        if (hand == null) {
            hand = new Hand();
        }
        return hand;
    }


    public List<String> getCards() {
        return this.cards;
    }
}
