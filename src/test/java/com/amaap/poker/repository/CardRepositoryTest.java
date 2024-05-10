package com.amaap.poker.repository;

import com.amaap.poker.PokerModule;
import com.amaap.poker.domain.model.entity.Card;
import com.amaap.poker.repository.impl.InMemoryCardRepository;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardRepositoryTest {

    @Inject
    CardRepository cardRepository;

    @BeforeEach
    public void setUp() {
        Injector injector = Guice.createInjector(new PokerModule());
        cardRepository = injector.getInstance(InMemoryCardRepository.class);
    }

    @Test
    void shouldBeAbleToSaveCard() {
        // arrange
        Card existingCard = new Card("H", "4");

        // act
        Card actual = cardRepository.save(existingCard);

        // assert
        assertEquals(existingCard, actual);
    }

    @Test
    void shouldBeAbleToGetCard() {
        // arrange
        Card existingCard = new Card("H", "4");
        cardRepository.save(existingCard);
        // act
        Card actual = cardRepository.getCardOf(1);

        // assert
        assertEquals("H", actual.getSuit());

    }


}