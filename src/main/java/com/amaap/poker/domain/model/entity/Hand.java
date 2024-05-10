package com.amaap.poker.domain.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private int id;
    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>(5);
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void setId(int id) {
        this.id = id;
    }
}
