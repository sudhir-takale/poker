package com.amaap.poker.repository.db.impl;

import com.amaap.poker.domain.model.entity.Card;
import com.amaap.poker.domain.model.entity.Hand;
import com.amaap.poker.repository.db.InMemoryDatabase;

import java.util.ArrayList;
import java.util.List;

public class FakeInMemoryDatabase implements InMemoryDatabase {
    private List<Card> cards = new ArrayList<>();
    private List<Hand> hands = new ArrayList<>();
    private int cardIdCounter = 0;
    private int handIdCounter = 0;

    @Override
    public Card getCard(int id) {
        return cards.get(id);
    }

    @Override
    public Card save(Card card) {
        card.setId(++cardIdCounter);
        cards.add(card);
        return card;
    }

    @Override
    public List<Card> getAllCards() {
        return this.cards;
    }

    @Override
    public Hand insert(Hand hand) {
        hand.setId(++handIdCounter);
        hands.add(hand);
        return hand;

    }

    @Override
    public List<Hand> getHandList() {
        return this.hands;
    }
}
