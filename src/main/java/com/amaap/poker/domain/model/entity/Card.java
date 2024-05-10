package com.amaap.poker.domain.model.entity;

import java.util.Objects;

public class Card {
    private final String suit;
    private final String value;
    private int id;

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(suit, card.suit) && Objects.equals(value, card.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, value);
    }

    public String getSuit() {
        return this.suit;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return this.value;
    }
}
