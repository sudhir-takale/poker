package com.amaap.poker.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<String> cards;

    public Hand() {

        cards = new ArrayList<>();
    }

    public List<String> getCards() {
        return this.cards;
    }
}
