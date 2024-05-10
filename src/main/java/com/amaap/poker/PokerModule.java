package com.amaap.poker;

import com.amaap.poker.repository.CardRepository;
import com.amaap.poker.repository.HandRepository;
import com.amaap.poker.repository.db.InMemoryDatabase;
import com.amaap.poker.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.poker.repository.impl.InMemoryCardRepository;
import com.amaap.poker.repository.impl.InMemoryHandRepository;
import com.google.inject.AbstractModule;

public class PokerModule extends AbstractModule {

    @Override
    public void configure() {
        bind(CardRepository.class).to(InMemoryCardRepository.class);
        bind(HandRepository.class).to(InMemoryHandRepository.class);
        bind(InMemoryDatabase.class).to(FakeInMemoryDatabase.class).asEagerSingleton();

    }


}
