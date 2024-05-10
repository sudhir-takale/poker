package com.amaap.poker.repository.impl;

import com.amaap.poker.domain.model.entity.Hand;
import com.amaap.poker.repository.HandRepository;
import com.amaap.poker.repository.db.InMemoryDatabase;
import com.google.inject.Inject;

import java.util.List;

public class InMemoryHandRepository implements HandRepository {

    private final InMemoryDatabase inMemoryDatabase;

    @Inject
    public InMemoryHandRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public Hand add(Hand hand) {
        return inMemoryDatabase.insert(hand);
    }

    @Override
    public List<Hand> getHandList() {
        return inMemoryDatabase.getHandList();
    }

    @Override
    public Hand getHand() {
        return inMemoryDatabase.getHand();
    }
}
