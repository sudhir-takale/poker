package com.amaap.poker.repository;

import com.amaap.poker.domain.model.entity.Card;
import com.amaap.poker.repository.db.InMemoryDatabase;
import com.google.inject.Inject;

import java.util.List;

public class InMemoryCardRepository implements CardRepository {
    private final InMemoryDatabase inMemoryDatabase;

    @Inject
    public InMemoryCardRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public Card save(Card card) {
        return inMemoryDatabase.save(card);
    }

    @Override
    public Card getCardOf(int id) {
        return inMemoryDatabase.getCard(id-1);
    }

    @Override
    public List<Card> getAllCards() {
        return inMemoryDatabase.getAllCards();
    }
}
