package com.amaap.poker.repository.db;

import com.amaap.poker.domain.model.entity.Card;
import com.amaap.poker.domain.model.entity.Hand;

import java.util.List;

public interface InMemoryDatabase {
    Card getCard(int id);

    Card save(Card card);

    List<Card> getAllCards();

    Hand insert(Hand hand);

    List<Hand> getHandList();
}
