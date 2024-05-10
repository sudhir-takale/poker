package com.amaap.poker.repository.db;

import com.amaap.poker.domain.model.entity.Card;

import java.util.List;

public interface InMemoryDatabase {
    Card getCard(int id);

    Card save(Card card);

    List<Card> getAllCards();
}
