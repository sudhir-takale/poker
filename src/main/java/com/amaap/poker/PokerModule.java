package com.amaap.poker;

import com.amaap.poker.repository.CardRepository;
import com.amaap.poker.repository.InMemoryCardRepository;
import com.amaap.poker.repository.db.InMemoryDatabase;
import com.amaap.poker.repository.db.impl.FakeInMemoryDatabase;
import com.google.inject.AbstractModule;

public class PokerModule extends AbstractModule {

    @Override
    public void configure() {
        bind(CardRepository.class).to(InMemoryCardRepository.class);
        bind(InMemoryDatabase.class).to(FakeInMemoryDatabase.class).asEagerSingleton();

    }


}
