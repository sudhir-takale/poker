package com.amaap.poker.repository;

import com.amaap.poker.domain.model.entity.Card;

import java.util.List;

public interface CardRepository {
    Card save(Card card);

    Card getCardOf(int id);

    List<Card> getAllCards();
}
